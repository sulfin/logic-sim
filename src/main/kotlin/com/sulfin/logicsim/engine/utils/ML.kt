package com.sulfin.logicsim.engine.utils

import com.sulfin.logicsim.engine.math.Vector2
import org.apache.logging.log4j.kotlin.Logging
import org.apache.logging.log4j.kotlin.logger
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class ML : MouseAdapter() {
    companion object : Logging

    private val buttonPressed: MutableSet<Int> = HashSet()


    private val pressCallbacks: MutableMap<Int, MutableList<(MouseEvent) -> Unit>> = HashMap()
    private val releaseCallbacks: MutableMap<Int, MutableList<(MouseEvent) -> Unit>> = HashMap()
    private val moveCallbacks: MutableMap<Int, MutableList<(MouseEvent) -> Unit>> = HashMap()
    private val dragCallbacks: MutableMap<Int, MutableList<(MouseEvent) -> Unit>> = HashMap()

    var mousePressed = false
    var mouseDragged = false
    var pos = Vector2(-1f, -1f)
    var dpos = Vector2(-1f, -1f)

    val rpos: Vector2
        get() = pos + dpos

    override fun mousePressed(e: MouseEvent) {
        mousePressed = true
        if (buttonPressed.add(e.button)) {
//            logger.debug("pressing ${e.button}")
            pressCallbacks[e.button]?.forEach { it(e) }
        }
    }

    override fun mouseReleased(e: MouseEvent) {
        mousePressed = false
        mouseDragged = false
        dpos = Vector2()

        if (buttonPressed.remove(e.button)) {
//            logger.debug("release ${e.button}")
            releaseCallbacks[e.button]?.forEach { it(e) }
        }
    }

    override fun mouseMoved(e: MouseEvent) {
        pos = Vector2(
            e.x.toFloat(),
            e.y.toFloat()
        )
        moveCallbacks[e.modifiersEx]?.forEach { it(e) }
    }

    override fun mouseDragged(e: MouseEvent) {
        mouseDragged = true
        dpos = Vector2(
            e.x - pos.x,
            e.y - pos.y,
        )
        dragCallbacks.filter { it.key and e.modifiersEx == it.key }.forEach { it.value.forEach { it(e) } }
    }

    fun registerMousePressed(button: Int, callback: (MouseEvent) -> Unit) {
        if (pressCallbacks[button] == null) pressCallbacks[button] = ArrayList()
        pressCallbacks[button]?.add(callback)
    }

    fun registerMouseReleased(button: Int, callback: (MouseEvent) -> Unit) {
        if (releaseCallbacks[button] == null) releaseCallbacks[button] = ArrayList()
        releaseCallbacks[button]?.add(callback)
    }

    fun registerMouseMoved(mask: Int, callback: (MouseEvent) -> Unit) {
        if (moveCallbacks[mask] == null) moveCallbacks[mask] = ArrayList()
        moveCallbacks[mask]?.add(callback)
    }

    fun registerMouseDragged(mask: Int, callback: (MouseEvent) -> Unit) {
        if (dragCallbacks[mask] == null) dragCallbacks[mask] = ArrayList()
        dragCallbacks[mask]?.add(callback)
    }

}