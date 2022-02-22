package com.sulfin.logicsim.engine

import java.awt.Graphics2D

class Renderer(
    val camera: Camera
) {
    val gameObjects: MutableList<GameObject> = ArrayList()

    fun submit(g: GameObject) {
        gameObjects.add(g)
    }

    fun render(g2: Graphics2D) {
        val affineTransform = camera.transform.affine
        g2.transform(affineTransform.createInverse())
        gameObjects.forEach { it.draw(g2) }
        g2.transform(affineTransform)
    }
}