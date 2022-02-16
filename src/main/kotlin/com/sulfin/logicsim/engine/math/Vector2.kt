package com.sulfin.logicsim.engine.math

data class Vector2(
    var x: Float = 0f,
    var y: Float = 0f
) {
    companion object {
        val One: Vector2
            get() = Vector2(1f, 1f)
    }

    operator fun plus(b: Any): Vector2 {
        return when (b) {
            is Vector2 -> Vector2(x + b.x, y + b.y)
            else -> throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        return "Vector2 ($x,$y)"
    }
}
