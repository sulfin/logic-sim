package com.sulfin.logicsim.app.scene

import com.sulfin.logicsim.app.component.Player
import com.sulfin.logicsim.app.component.RectComp
import com.sulfin.logicsim.engine.GameObject
import com.sulfin.logicsim.engine.Scene
import com.sulfin.logicsim.engine.Transform
import com.sulfin.logicsim.engine.Window
import com.sulfin.logicsim.engine.component.BoxBounds
import com.sulfin.logicsim.engine.component.CameraPanning
import com.sulfin.logicsim.engine.component.FPSCounter
import com.sulfin.logicsim.engine.component.SpriteComponent
import com.sulfin.logicsim.engine.math.Vector2
import java.awt.Color
import java.awt.Graphics2D

class TestScene(
    window: Window
) : Scene("Test Scene", window) {

    override fun init() {
        println("Initializing $name...")
        val testbj = GameObject(this)
        testbj.addComponent(FPSCounter())
        testbj.addComponent(BoxBounds(Vector2(200f, 200f)))
        testbj.addComponent(CameraPanning(camera))

        val player = GameObject(this, Transform(Vector2(400f, 300f)))
        player.addComponent(SpriteComponent("assets/sprites/cube.png"))
        player.addComponent(Player())

        val rect = GameObject(
            player,
            Transform(
                Vector2(400f, 200f),
                Vector2(.5f, .5f),
                Math.PI.toFloat()
            )
        )
        rect.addComponent(BoxBounds(Vector2(500f, 400f)))
        rect.addComponent(RectComp(Vector2(500f, 400f), Color.CYAN))
    }

    override fun updateScene(dt: Double) {
    }

    override fun drawScene(g2: Graphics2D) {
        g2.color = Color.decode("#999")
        g2.fillRect(0, 0, window.width, window.height)
    }
}