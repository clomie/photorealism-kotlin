package net.clomie.photorealism.chapter2

abstract class Camera(val camPos: Vec3, val camForward: Vec3) {
    val camRight: Vec3
    val camUp: Vec3

    init {
        val (right, up) = orthonormalBasis(camForward)
        camRight = right
        camUp = up
    }

    override fun toString(): String {
        return """
            camPos: $camPos
            camForward: $camForward
            camRight: $camRight
            camUp: $camUp
        """.trimIndent()
    }

    abstract fun getRay(u: Double, v: Double): Ray
}