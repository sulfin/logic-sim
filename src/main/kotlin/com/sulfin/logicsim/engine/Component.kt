package com.sulfin.logicsim.engine

import java.awt.Graphics2D

abstract class Component(
    val name: String,
) {

    lateinit var gameObject: GameObject

    open fun init() {

    }

    open fun update(dt: Double) {

    }

    open fun draw(g2: Graphics2D) {

    }
}