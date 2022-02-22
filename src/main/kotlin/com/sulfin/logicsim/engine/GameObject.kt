package com.sulfin.logicsim.engine

import java.awt.Graphics2D
import java.awt.geom.AffineTransform
import kotlin.reflect.KClass
import kotlin.reflect.cast
import kotlin.system.exitProcess

class GameObject(
    val name: String,
    val transform: Transform = Transform()
) {
    private val components: MutableList<Component> = ArrayList()

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
        components.add(c)
        c.gameObject = this
    }

    fun update(dt: Double) {
        components.forEach {
            it.update(dt)
        }
    }

    fun draw(g2: Graphics2D) {
        val affineTransform = transform.affine
        g2.transform(affineTransform)
        components.forEach {
            it.draw(g2)
        }
        g2.transform(affineTransform.createInverse())
    }

}