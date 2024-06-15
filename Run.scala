object Run {
  def easy(dist: Int): Int = dist * 8
  def tempo(dist: Int): Int = dist * 7

  def main(args: Array[String]): Unit = {
    val time = easy(2) + tempo(3) + easy(2)
    println(s"Total time duratio is $time")
  }
}
