package com.sulfin.logicsim.engine.asset

import com.sulfin.logicsim.engine.asset.impl.Sprite
import org.apache.logging.log4j.kotlin.Logging
import java.io.File
import java.io.IOException
import kotlin.system.exitProcess


class AssetPool {
    companion object : Logging {

        val assets: MutableMap<String, Asset> = HashMap()

        inline fun <reified T : Asset> load(path: String): T? {
            val absoluteFilePath: String = File(path).absolutePath
            if (assets.containsKey(absoluteFilePath)) {
                val asset = assets[absoluteFilePath]
                if (T::class.isInstance(asset)) {
                    return asset as T
                } else {
                    logger.error("The asset loaded as $absoluteFilePath is not of type ${T::class}")
                    return null
                }
            } else {
                try {
                    when (T::class) {
                        Sprite::class -> return instanceSprite(absoluteFilePath) as T
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                    exitProcess(-2)
                }
                return null
            }
        }


        fun instanceSprite(path: String): Sprite {
            val sprite = Sprite(path)
            assets[path] = sprite
            logger.info("Loaded Sprite from $path")
            return sprite
        }
    }
}