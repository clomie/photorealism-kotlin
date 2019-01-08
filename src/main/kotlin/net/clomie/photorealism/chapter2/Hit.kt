package net.clomie.photorealism.chapter2

class Hit(var t: Double) {
    var hitPos: Vec3? = null
    var hitNormal: Vec3? = null
    var hitSphere: Sphere? = null

    constructor() : this(10000.0)
}