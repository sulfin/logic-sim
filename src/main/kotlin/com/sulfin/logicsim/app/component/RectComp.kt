package com.sulfin.logicsim.app.component

import com.sulfin.logicsim.engine.Component
import com.sulfin.logicsim.engine.math.Vector2
import java.awt.Color
import java.awt.Graphics2D

class RectComp(val size: Vector2, val color: Color) : Component("Rect") {
    override fun draw(g2: Graphics2D) {
        g2.color = color
        g2.fillRect(0, 0, size.x.toInt(), size.y.toInt())
    }
}