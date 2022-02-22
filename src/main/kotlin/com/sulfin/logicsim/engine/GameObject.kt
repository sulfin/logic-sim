package com.sulfin.logicsim.engine

import org.apache.logging.log4j.kotlin.Logging
import java.awt.Graphics2D
import kotlin.reflect.KClass
import kotlin.reflect.cast
import kotlin.system.exitProcess

class GameObject(
    val parent: GameObjectContainer,
    val transform: Transform = Transform(),
) : GameObjectContainer {
    companion object : Logging

    private val components: MutableList<Component> = ArrayList()

    val children: MutableList<GameObject> = ArrayList()

    init {
        parent.addGameObject(this)
    }

    override fun addGameObject(gameObject: GameObject) {
        children.add(gameObject)
    }

    fun <C : Component> getComponent(c: KClass<C>): C? {
        components.forEach {
            if (c.isInstance(it)) {
                try {
                    return c.cast(it)
                } catch (e: ClassCastException) {
                    e.printStackTrace()
                    exitProcess(-1)
                }
            }
        }
        return null
    }

    fun addComponent(c: Component) {
        if (getComponent(c::class) == null) {
            components.add(c)
            c.gameObject = this
        } else {
            logger.error("An object can't have two component of the same type: ${c::class}")
            exitProcess(-10)
        }
    }

    fun update(dt: Double) {
        components.forEach {
            it.update(dt)
        }
        children.forEach {
            it.update(dt)
        }
    }

    fun draw(g2: Graphics2D) {
        val affineTransform = transform.affine
        g2.transform(affineTransform)
        components.forEach {
            it.draw(g2)
        }
        children.forEach {
            it.draw(g2)
        }
        g2.transform(affineTransform.createInverse())
    }

}