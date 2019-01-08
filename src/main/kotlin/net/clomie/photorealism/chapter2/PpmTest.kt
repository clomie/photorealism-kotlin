package net.clomie.photorealism.chapter2

import java.io.File

fun main(args: Array<String>) {

    val file = File("images/ppm_test.ppm")

    file.printWriter().use { w ->
        w.println("P3")
        w.println("512 512")
        w.println("255")
        for (i in 0 until 512) {
            for (j in 0 until 512) {
                val r = (i / 512.0 * 255).toInt()
                val g = (j / 512.0 * 255).toInt()
                val b = 255
                w.println("$r $g $b")
            }
        }
    }
}