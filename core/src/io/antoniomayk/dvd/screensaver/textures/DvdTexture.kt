package io.antoniomayk.dvd.screensaver.textures

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import io.antoniomayk.dvd.screensaver.enums.CommonColor
import io.antoniomayk.dvd.screensaver.utils.PixmapUtils

class DvdTexture(assetPath: String) {
    lateinit var texture: Texture

    private var colorIndex: Int = (0..CommonColor.entries.size).random()

    init {
        changeColor(Pixmap(Gdx.files.internal(assetPath)))
    }

    fun changeColor() {
        changeColor(texture.textureData.consumePixmap())
    }

    private fun changeColor(pixmap: Pixmap) {
        val latestColor = CommonColor.entries[nextColor()].color

        if (::texture.isInitialized) {
            texture.dispose()
        }

        texture = Texture(PixmapUtils.copyNonAlphaPixels(pixmap, latestColor))

        pixmap.dispose()
    }

    private fun nextColor(): Int {
        colorIndex = if (colorIndex >= CommonColor.entries.size - 1) 0 else colorIndex + 1
        return colorIndex
    }
}
