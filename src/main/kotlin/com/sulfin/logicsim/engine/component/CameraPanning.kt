package com.sulfin.logicsim.engine.component

import com.sulfin.logicsim.engine.Camera
import com.sulfin.logicsim.engine.Component
import com.sulfin.logicsim.engine.Window
import com.sulfin.logicsim.engine.datastructure.Box
import com.sulfin.logicsim.engine.math.Vector2
import org.apache.logging.log4j.kotlin.Logging
import java.awt.event.MouseEvent

class CameraPanning(
    val camera: Camera,
    val limits: Box? = null
) : Component("CameraPanning") {
    companion object : Logging

    val ml = Window.instance.ml

    var panning = false
    var cameraPosBefore = Vector2()

    var pushPos = Vector2()
    var dpos = Vector2()

    init {
        ml.registerMousePressed(2) {
//            logger.debug("panning true")
            cameraPosBefore = camera.transform.position.copy()
            dpos = Vector2()
            pushPos = Vector2(it.x.toFloat(), it.y.toFloat())
            panning = true
        }
        ml.registerMouseReleased(2) {
//            logger.debug("panning false")
            panning = false
        }
        println(MouseEvent.getMaskForButton(MouseEvent.BUTTON2))
        ml.registerMouseDragged(MouseEvent.getMaskForButton(MouseEvent.BUTTON2)) {
            dpos = Vector2(it.x.toFloat(), it.y.toFloat()) - pushPos
        }

    }

    private val cameraPosDuring: Vector2
        get() {
            val pos = cameraPosBefore - dpos
            return limits?.makeInside(pos) ?: pos
        }

    override fun update(dt: Double) {
        if (panning) {
            camera.transform.position = cameraPosDuring
        }

//        if (panning) {
//            if (ml.mouseDragged && ml.mouseButton == 2) {
//                camera.transform.position = cameraPosDuring
//            } else {
//                panning = false
//            }
//        } else {
//            if (ml.mouseDragged && ml.mouseButton == 2) {
//                panning = true
//                cameraPosBefore = camera.transform.position.copy()
//            }
//        }
    }
}