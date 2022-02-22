package com.sulfin.logicsim.engine

import com.sulfin.logicsim.engine.math.Vector2
import java.awt.geom.AffineTransform

data class Transform(
    var position: Vector2 = Vector2(),
    var scale: Vector2 = Vector2.One,
    var rotation: Float = 0f
) {
    val affine: AffineTransform
        get() {
            val affineTransform = AffineTransform()
            affineTransform.setToIdentity()
            affineTransform.translate(position.x.toDouble(), position.y.toDouble())
            affineTransform.rotate(rotation.toDouble())
            affineTransform.scale(scale.x.toDouble(), scale.y.toDouble())
            return affineTransform
        }
}