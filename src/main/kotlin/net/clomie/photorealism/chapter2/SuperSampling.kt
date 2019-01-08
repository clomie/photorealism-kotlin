package net.clomie.photorealism.chapter2

import kotlin.math.max
import kotlin.random.Random

fun main(args: Array<String>) {

    val img = Image(512, 512)
    val cam = PinholeCamera(Vec3(0, 0, 0), Vec3(0, 0, -1), 1.0)

    val sphere = Sphere(Vec3(0, 0, -3), 1.0)
    val floor = Sphere(Vec3(0, -10001, 0), 10000.0)

    val aggregate = Aggregate()
    aggregate.add(sphere)
    aggregate.add(floor)

    val sunDir = normalize(Vec3(1, 1, 1))

    val samplingCount = 100
    val rnd = Random(System.currentTimeMillis())

    fun color(ray: Ray): Vec3 {
        val hit = aggregate.intersect(ray)
        if (hit != null) {
            val shadowRay = Ray(hit.hitPos + 0.001 * hit.hitNormal, sunDir)
            // 光源方向へ飛ばしたレイが衝突しなければ光の強さを計算
            if (aggregate.intersect(shadowRay) == null) {
                return max(dot(hit.hitNormal, sunDir), 0.0) * Vec3(1)
            }
        }

        return Vec3(0, 0, 0)
    }

    val loops = samplingCount * img.width * img.height

    for (count in 0 until loops) {
        val i = count / img.height % img.width
        val j = count % img.height

        val u = (2.0 * (i + rnd.nextDouble()) - img.width) / img.width
        val v = (2.0 * (j + rnd.nextDouble()) - img.height) / img.height
        val ray = cam.getRay(-u, -v)

        img[i, j] += color(ray)
    }

    img.devide(samplingCount.toDouble())
    img.outputPpm("images/super_sampling.ppm")
}
