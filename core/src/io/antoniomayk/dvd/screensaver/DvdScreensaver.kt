package io.antoniomayk.dvd.screensaver

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import io.antoniomayk.dvd.screensaver.misc.DvdBouncing
import io.antoniomayk.dvd.screensaver.textures.DvdTexture

class DvdScreensaver : Game() {
    private lateinit var batch: SpriteBatch
    private lateinit var dvdBouncing: DvdBouncing

    override fun create() {
        batch = SpriteBatch()
        dvdBouncing = DvdBouncing(DvdTexture("logo.png"), 600F, 400F)
    }

    override fun render() {
        ScreenUtils.clear(Color.BLACK)

        batch.begin()

        dvdBouncing.motion()

        batch.draw(
            dvdBouncing.dvdTexture.texture,
            dvdBouncing.x,
            dvdBouncing.y,
            dvdBouncing.textureSize,
            dvdBouncing.textureSize
        )

        batch.end()
    }

    override fun dispose() {
        batch.dispose()
    }
}
