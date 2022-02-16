/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.sulfin.logicsim

import com.sulfin.logicsim.app.MainWindow
import com.sulfin.logicsim.engine.Window
import com.sulfin.logicsim.engine.math.Vector2
import com.sulfin.logicsim.engine.utils.Timer
import com.sun.tools.javac.Main

fun main() {
    val window = MainWindow()

    val mainThread = Thread(window)
    mainThread.start()

}
