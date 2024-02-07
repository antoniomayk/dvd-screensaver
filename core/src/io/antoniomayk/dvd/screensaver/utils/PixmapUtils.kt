package io.antoniomayk.dvd.screensaver.utils

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap

object PixmapUtils {
    /**
     * Copy all non alpha pixels to a new [Pixmap] using [Pixmap.Format.RGBA8888] format.
     *
     * @param originalPixmap Original [Pixmap]
     * @param color New color that will be drawn
     *
     * @return A new [Pixmap]
     */
    fun copyNonAlphaPixels(originalPixmap: Pixmap, color: Color): Pixmap {
        val newPixmap = Pixmap(originalPixmap.width, originalPixmap.height, Pixmap.Format.RGBA8888)

        for (x in 0..originalPixmap.width) {
            for (y in 0..originalPixmap.height) {
                val pixel = originalPixmap.getPixel(x, y)
                val pixelColor = Color(pixel)
                if (pixelColor.a != 0F) {
                    newPixmap.setColor(color)
                    newPixmap.drawPixel(x, y)
                }
            }
        }

        return newPixmap
    }
}
