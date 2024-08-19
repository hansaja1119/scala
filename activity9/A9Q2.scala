object A9Q2 {
  def patternMatching(num: Int): Unit = {
    num match {
      case x if x <= 0     => println("Negative/Zero")
      case x if x % 2 == 0 => println("Even number is given")
      case x if x % 2 != 0 => println("Odd number is given")
    }
  }

  def main(args: Array[String]): Unit = {
    println("Enter a number: ")
    val num = scala.io.StdIn.readInt()
    patternMatching(num)
  }
}
