object Q1 {
  // reverse of the string using recursion
  def reverse(s: String): String = s match {
    case "" => ""
    case _  => reverse(s.tail) + s.head
  }

  def main(args: Array[String]): Unit = {
    val string = "Hello World"
    println(reverse(string))
  }
}
