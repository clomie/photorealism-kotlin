package net.clomie.photorealism.chapter2

fun main(vararg args: String) {
    val v1 = Vec3(1, 2, 3)
    val v2 = Vec3(4, 5, 6)

    println(v1 + v2)
    println(v1 - v2)
    println(v1 * v2)
    println(v1 / v2)

    println(v1 + 1)
    println(v1 - 1)
    println(v1 * 2)
    println(v1 / 2)

    println(dot(v1, v2))
    println(cross(v1, v2))

    println(v1.length())
}