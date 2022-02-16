package com.sulfin.logicsim.app.scene

import com.sulfin.logicsim.engine.Scene
import com.sulfin.logicsim.engine.Window
import java.awt.Color
import java.awt.Graphics2D
import java.awt.event.KeyEvent

class TestScene(
    window: Window
) : Scene("Test Scene", window) {

    var showFPS = true

    override fun init() {
        println("Initializing $name...")
    }

    override fun update(dt: Double) {
        if (showFPS) {
            window.title = "${window.baseTitle} - " + "%.2f FPS".format(1 / dt)
        }
    }

    override fun draw(g2: Graphics2D) {
        g2.color = Color.decode("#222")
        g2.fillRect(0, 0, window.width, window.height)

        g2.color = if (ml.pos.x > 400 && ml.pos.x < 700 && ml.pos.y > 200 && ml.pos.y < 400) Color.GREEN else Color.BLUE
        g2.fillRect(400, 200, 300, 200)

        if (kl.isKeyPressed(KeyEvent.VK_SPACE)) {
            g2.color = Color.RED
            g2.fillOval(window.width / 2, window.height / 2, 100, 50)
        }
    }
}