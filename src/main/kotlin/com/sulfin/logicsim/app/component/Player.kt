package com.sulfin.logicsim.app.component

import com.sulfin.logicsim.engine.Component
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class Player : Component("Player") {

    val vr = Math.PI * 2
    val r = 250
    var t = 0.0
    val f = .1
    override fun update(dt: Double) {
        t += dt
        gameObject.transform.position.x = 400+(r * cos(PI * 2 * f * t)).toFloat()
        gameObject.transform.position.y = 300+(r * sin(PI * 2 * f * t)).toFloat()

        gameObject.transform.rotation += (vr * dt).toFloat()
        gameObject.transform.scale.x = (1 + 0.5 * sin(2* PI * .1 * t)).toFloat()
        gameObject.transform.scale.y = (1 + 0.5 * sin(2* PI * .1 * t)).toFloat()
    }
}