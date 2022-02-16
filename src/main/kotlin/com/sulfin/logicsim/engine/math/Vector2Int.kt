package com.sulfin.logicsim.engine.math

data class Vector2Int(
    var x: Int = 0,
    var y: Int = 0
) {
    companion object {
        val One: Vector2Int
            get() = Vector2Int(1, 1)
    }

    operator fun plus(b: Any): Vector2Int {
        return when (b) {
            is Vector2Int -> Vector2Int(x + b.x, y + b.y)
            else -> throw IllegalArgumentException()
        }
    }
}
