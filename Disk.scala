object Disk {
  def areaOfDisk(r: Double): Double = math.Pi * r * r

  def main(args: Array[String]): Unit = {
    val radius = 5.0
    val area = areaOfDisk(radius)
    println(s"Area of a disk with radius $radius is $area")
  }
}
