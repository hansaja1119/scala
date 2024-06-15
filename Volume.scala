object Volume {
  def volumeOfSpere(r: Double): Double = 4 / 3 * math.Pi * r * r * r

  def main(args: Array[String]): Unit = {
    val radius = 5.0
    val volume = volumeOfSpere(radius)
    println(s"Volume of a sphere with radius $radius is $volume")
  }
}
