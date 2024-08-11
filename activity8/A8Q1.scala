import scala.io.StdIn.readLine

object A8Q1 {
  def pattern(No: Int): Unit = {
    No match {
      case x if (x % 3 == 0 && x % 5 == 0) =>
        println("Multiple of Both Three and Five")
      case x if (x % 3 == 0) => println("Multiple of Three")
      case x if (x % 5 == 0) => println("Multiple of Five")
      case _                 => println("Not a Multiple of Three or Five")
    }
  }

  def main(args: Array[String]): Unit = {
    try {
      val number = readLine("Enter a number: ").toInt
      if (number <= 0) {
        println("Please enter a positive integer")
      } else {
        pattern(number)
      }
    } catch {
      case _: NumberFormatException => println("Enter a valid number")
    }
  }
}
