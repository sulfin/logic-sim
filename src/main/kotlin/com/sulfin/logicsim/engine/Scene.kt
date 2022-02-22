package com.sulfin.logicsim.engine

import java.awt.Graphics2D

abstract class Scene(
    val name: String,
    val window: Window
) {
    val ml = window.ml
    val kl = window.kl

    val camera = Camera()
    val renderer = Renderer(camera)
    val gameObjects: MutableList<GameObject> = ArrayList()

    abstract fun init()

    fun addGameObject(g: GameObject) {
        gameObjects.add(g)
        renderer.submit(g)
    }

    fun update(dt: Double) {
        updateScene(dt)
        gameObjects.forEach { it.update(dt) }
    }

    fun draw(g2: Graphics2D) {
        drawScene(g2)
        renderer.render(g2)
    }

    open fun updateScene(dt: Double) {

    }

    open fun drawScene(g2: Graphics2D) {

    }
}