package com.sulfin.logicsim.engine.utils

import com.sulfin.logicsim.engine.math.Vector2
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class ML : MouseAdapter() {
    var mousePressed = false
    var mouseDragged = false
    var mouseButton = -1
    var pos = Vector2(-1f, -1f)
    var dpos = Vector2(-1f, -1f)

    val rpos: Vector2
        get() = pos + dpos

    override fun mousePressed(e: MouseEvent) {
        mousePressed = true
        mouseButton = e.button
    }

    override fun mouseReleased(e: MouseEvent) {
        mousePressed = false
        mouseDragged = false
        dpos = Vector2()
    }

    override fun mouseMoved(e: MouseEvent) {
        pos = Vector2(
            e.x.toFloat(),
            e.y.toFloat()
        )
    }

    override fun mouseDragged(e: MouseEvent) {
        mouseDragged = true
        dpos = Vector2(
            e.x - pos.x,
            e.y - pos.y,
        )
    }

}