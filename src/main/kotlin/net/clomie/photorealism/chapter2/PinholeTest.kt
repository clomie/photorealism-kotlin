package net.clomie.photorealism.chapter2

fun main(args: Array<String>) {
    val img = Image(512, 512)
    val cam = PinholeCamera(Vec3(0, 0, 0), Vec3(0, 0, -1), 1.0)

    println(cam)

    for (i in 0 until img.width) {
        for (j in 0 until img.height) {
            val u = (2.0 * i - img.width) / img.width
            val v = (2.0 * j - img.height) / img.height
            val ray = cam.getRay(-u, -v)
            val col = (ray.direction + 1.0) / 2.0
            img[i, j] = col
        }
    }

    img.outputPpm("images/pinhole_test.ppm")
}