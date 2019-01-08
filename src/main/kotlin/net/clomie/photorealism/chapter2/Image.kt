package net.clomie.photorealism.chapter2

import java.io.File

class Image(val width: Int, val height: Int) {
    private var data: Array<Vec3> = Array(width * height) {
        Vec3(
            0
        )
    }

    operator fun get(x: Int, y: Int) = data[x + width * y]
    operator fun set(x: Int, y: Int, c: Vec3) {
        data[x + width * y] = c
    }

    fun devide(k: Double) {
        for ((i, value) in data.withIndex()) {
            data[i] = value / k
        }
    }

    fun applyGammaCorrection() {
        fun g(k: Double) = Math.pow(k, 1 / 2.2)

        for ((i, pixel) in data.withIndex()) {
            data[i] = Vec3(g(pixel.x), g(pixel.y), g(pixel.z))
        }
    }

    fun outputPpm(filename: String) {
        fun c(k: Double) = clamp((255 * k).toInt(), 0, 255)

        val file = File(filename)
        file.printWriter().use { w ->
            w.println("P3")
            w.println("$width $height")
            w.println("255")
            for (pixel in data) {
                val r = c(pixel.x)
                val g = c(pixel.y)
                val b = c(pixel.z)
                w.println("$r $g $b")
            }
        }
    }

}
