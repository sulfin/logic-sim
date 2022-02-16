package com.sulfin.logicsim.engine.utils

class Timer {
    private val initTimeNs = System.nanoTime()

    /**
     * Time in second since instantiation
     */
    val time: Double
        get() = (System.nanoTime() - initTimeNs) * 1E-9

    /**
     * Time of the last call
     */
    var lastTimeNs: Long = initTimeNs

    /**
     * Time in second since last call
     */
    val dt: Double
        get() {
            val elapsed = System.nanoTime() - lastTimeNs
            lastTimeNs = System.nanoTime()
            return elapsed * 1E-9
        }
    val peekdt :Double
    get() = (System.nanoTime() - lastTimeNs) * 1E-9

    fun resetdt(){
        lastTimeNs = System.nanoTime()
    }
}