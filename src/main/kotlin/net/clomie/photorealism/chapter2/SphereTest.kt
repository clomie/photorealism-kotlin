package net.clomie.photorealism.chapter2

fun main(args: Array<String>) {
    val s = Sphere(Vec3(0, 0, 0), 1.0);
    val ray = Ray(Vec3(0, 0, -3), Vec3(0, 0, 1))

    s.intersect(ray)?.let {
        println(it.hitPos)
    }
}