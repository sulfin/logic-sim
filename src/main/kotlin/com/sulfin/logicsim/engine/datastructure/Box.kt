package com.sulfin.logicsim.engine.datastructure

import com.sulfin.logicsim.engine.math.Vector2

data class Box(
    var origin: Vector2,
    var size: Vector2
) {
    fun makeInside(position: Vector2): Vector2 {
        if (position.x < origin.x) position.x = origin.x
        if (position.x > origin.x + size.x) position.x = origin.x + size.x
        if (position.y < origin.y) position.y = origin.y
        if (position.y > origin.y + size.y) position.y = origin.y + size.y
        return position
    }
}
