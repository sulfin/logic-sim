package com.sulfin.logicsim.engine

import java.awt.Graphics2D

abstract class Scene(
    val name: String,
    val window: Window
) {
    val ml = window.ml
    val kl = window.kl

    abstract fun init()
    abstract fun update(dt: Double)
    abstract fun draw(g2: Graphics2D)
}