package io.antoniomayk.dvd.screensaver

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = Lwjgl3ApplicationConfiguration()
        config.setWindowedMode(600, 400)
        config.setTitle("DVD Screensaver")
        config.useVsync(true)
        config.setForegroundFPS(120)
        Lwjgl3Application(DvdScreensaver(), config)
    }
}
