package net.clomie.photorealism.chapter2

fun main(args: Array<String>) {
    val r = Ray(
        Vec3(0, 0, 0),
        Vec3(0, 0, 1)
    )
    println(r)
    println(r(10))
}