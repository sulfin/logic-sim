package com.sulfin.logicsim.engine.asset.impl

import com.sulfin.logicsim.engine.asset.Asset
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

data class Sprite(
    val path: String
) : Asset {

    val image: BufferedImage = ImageIO.read(File(path))

    val width: Int = image.width
    val height: Int = image.height

}