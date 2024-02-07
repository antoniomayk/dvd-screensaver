package io.antoniomayk.dvd.screensaver.misc

import com.badlogic.gdx.Gdx
import io.antoniomayk.dvd.screensaver.textures.DvdTexture

class DvdBouncing(
    val dvdTexture: DvdTexture,
    windowWidth: Float,
    windowHeight: Float
) {
    var x = (40..160).random().toFloat()
        private set
    var y = (40..160).random().toFloat()
        private set

    val textureSize = 60F

    private val bottomSide = 0F
    private val topSide = windowHeight - textureSize
    private val rightSide = 0F
    private val leftSide = windowWidth - textureSize

    private val speed = 40F

    private var positiveXMotion = false
    private var positiveYMotion = false

    fun motion() {
        if (x > leftSide) positiveXMotion = false
        if (x < rightSide) positiveXMotion = true

        if (y > topSide) positiveYMotion = false
        if (y < bottomSide) positiveYMotion = true

        if (x > leftSide
            || x < rightSide
            || y > topSide
            || y < bottomSide
        ) dvdTexture.changeColor()

        x = if (positiveXMotion) x + speed * Gdx.graphics.deltaTime else x - speed * Gdx.graphics.deltaTime
        y = if (positiveYMotion) y + speed * Gdx.graphics.deltaTime else y - speed * Gdx.graphics.deltaTime
    }
}
