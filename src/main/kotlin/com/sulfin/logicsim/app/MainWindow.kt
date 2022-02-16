package com.sulfin.logicsim.app

import com.sulfin.logicsim.app.scene.TestScene
import com.sulfin.logicsim.engine.Window
import java.awt.Dimension

class MainWindow : Window() {
    init {
        baseTitle = "Sim"

        size = Dimension(1280, 720)
        isResizable = false
        title = baseTitle
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
        setLocationRelativeTo(null)
    }

    override fun changeScene(index: Int) {
        when (index) {
            0 -> activeScene = TestScene(this)
            else -> throw IllegalArgumentException("The Scene $index does not exist !")
        }
        activeScene?.init()
    }

    override fun init() {
        changeScene(0)
    }
}