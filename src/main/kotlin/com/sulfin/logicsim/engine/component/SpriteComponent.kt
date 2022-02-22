package com.sulfin.logicsim.engine.component

import com.sulfin.logicsim.engine.Component
import com.sulfin.logicsim.engine.GameObject
import com.sulfin.logicsim.engine.asset.AssetPool
import com.sulfin.logicsim.engine.asset.impl.Sprite
import java.awt.Graphics2D

class SpriteComponent(
    path: String
) : Component("Sprite") {
    private val sprite = AssetPool.load<Sprite>(path)


    override fun draw(g2: Graphics2D) {
        g2.drawImage(
            sprite?.image,
            (sprite?.width ?: 0) / -2,
            (sprite?.height ?: 0) / -2,
            sprite?.width ?: 0,
            sprite?.height ?: 0,
            null
        )
    }
}