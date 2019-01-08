package net.clomie.photorealism.chapter2

class PinholeCamera(camPos: Vec3, camForward: Vec3, val pinholeDist: Double) : Camera(camPos, camForward) {

    override fun getRay(u: Double, v: Double): Ray {
        val pinholePos = camPos + pinholeDist * camForward
        val sensorPos = camPos + u * camRight + v * camUp
        return Ray(sensorPos, normalize(pinholePos - sensorPos))
    }

}