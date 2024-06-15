object Temp {
  def temp(c: Double): Double = c * 1.8 + 32

  def main(args: Array[String]): Unit = {
    val celcius = 35.0
    val far = temp(celcius)
    println(s"$celcius C = $far F")
  }
}
