package net.clomie.photorealism.chapter2

fun main(args: Array<String>) {
    val img = Image(512, 512)
    for (i in 0 until img.width) {
        for (j in 0 until img.height) {
            img[i, j] = Vec3(i / img.width.toDouble(), j / img.height.toDouble(), 1.0)
        }
    }
    img.outputPpm("images/image_test.ppm")
}