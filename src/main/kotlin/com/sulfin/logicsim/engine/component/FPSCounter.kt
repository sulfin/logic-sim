package com.sulfin.logicsim.engine.component

import com.sulfin.logicsim.engine.Component
import com.sulfin.logicsim.engine.GameObject
import com.sulfin.logicsim.engine.Window

class FPSCounter : Component("Fps counter") {
    override fun update(dt: Double) {
        Window.instance.title = "${Window.instance.baseTitle} - " + "%.2f FPS".format(1 / dt)
    }
}