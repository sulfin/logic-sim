package com.sulfin.logicsim.engine.component

import com.sulfin.logicsim.engine.Component
import com.sulfin.logicsim.engine.GameObject
import com.sulfin.logicsim.engine.math.Vector2

class BoxBounds(
    var size: Vector2
) : Component("BoxBounds") {
    fun isInside(p: Vector2): Boolean {
        //considering size and rotation to default and in screen space
        return p.x >= gameObject.transform.position.x &&
                p.x <= gameObject.transform.position.x + size.x &&
                p.y >= gameObject.transform.position.y &&
                p.y <= gameObject.transform.position.y + size.y
    }
}