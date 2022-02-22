package com.sulfin.logicsim.engine

import com.sulfin.logicsim.engine.utils.KL
import com.sulfin.logicsim.engine.utils.ML
import com.sulfin.logicsim.engine.utils.Timer
import java.awt.Graphics2D
import java.awt.Image
import javax.swing.JFrame

abstract class Window(

) : JFrame(), Runnable {

    companion object {
        lateinit var instance: Window
    }

    init {
        instance = this
    }

    val ml = ML()
    val kl = KL()

    init {
        addMouseListener(ml)
        addMouseMotionListener(ml)
        addKeyListener(kl)
    }

    var doubleBufferImage: Image? = null


    var activeScene: Scene? = null

    // TODO need to be in a config class
    var running = true
    var limitFPS = true
    var maxFPS = 60

    // TODO default config, need to bve in a class
    var baseTitle = ""

    abstract fun changeScene(index: Int)

    fun update(dt: Double) {
        activeScene?.update(dt)
        draw(graphics as Graphics2D)
    }

    fun draw(g2: Graphics2D) {
        if (doubleBufferImage == null) {
            doubleBufferImage = createImage(width, height)
        }
        if (doubleBufferImage != null) {
            renderOffScreen(doubleBufferImage!!.graphics as Graphics2D)
            g2.drawImage(doubleBufferImage, 0, 0, width, height, null)
        } else {
            println("Cannot use double buffer image, drawing directly on screen")
            renderOffScreen(g2)
        }
    }

    fun renderOffScreen(g2: Graphics2D) {
        activeScene?.draw(g2)
    }

    abstract fun init()

    override fun run() {
        val timer = Timer()
        init()
        try {
            while (running) {

                if (limitFPS) {
                    //dirty way of capping fps
                    while (1 / timer.peekdt > maxFPS) {

                    }
                    //better way but not working
                    /*
                    if (1 / maxFPS > timer.peekdt) {
                        Thread.sleep(((1 / maxFPS - timer.peekdt) * 1E3).toLong())
                    }
                     */
                }
                //call the mother of all update
                update(timer.dt)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}