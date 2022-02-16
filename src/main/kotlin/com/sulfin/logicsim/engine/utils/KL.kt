package com.sulfin.logicsim.engine.utils

import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

class KL : KeyAdapter() {
    private val keyPressed: MutableSet<Int> = HashSet()

    override fun keyPressed(e: KeyEvent) {
        if (!keyPressed.contains(e.keyCode)) {
            keyPressed.add(e.keyCode)
        }
    }

    override fun keyReleased(e: KeyEvent) {
        keyPressed.remove(e.keyCode)
    }

    fun isKeyPressed(keyCode: Int) = keyPressed.contains(keyCode)
}