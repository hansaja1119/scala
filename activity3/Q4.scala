import scala.io.StdIn.readLine

object Q4 {
  def collectUserInputs(): List[Int] = {
    println("Enter integers one by one, and type 'done' when finished:")

    var input = ""
    var numberList = List[Int]()
    while (input != "done") {
      input = readLine()
      if (input != "done") {
        try {
          numberList = numberList :+ input.toInt
        } catch {
          case _: NumberFormatException =>
            println("Please enter a valid integer.")
        }
      }
    }
    numberList
  }

  def sumOfEvenNumbers(numbers: List[Int]): Int = {
    numbers.filter(_ % 2 == 0).sum
  }

  def main(args: Array[String]): Unit = {
    val numbers = collectUserInputs()

    val sum = sumOfEvenNumbers(numbers)

    println(s"The sum of all even numbers in the list is: $sum")
  }
}
