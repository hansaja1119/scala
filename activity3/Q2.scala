import scala.io.StdIn.readLine

object Q2 {
  def collectUserInputs(): List[String] = {
    println("Enter strings one by one, and type 'done' when finished:")

    var input = ""
    var stringList = List[String]()
    while (input != "done") {
      input = readLine()
      if (input != "done") {
        stringList = stringList :+ input
      }
    }
    stringList
  }

  def filterLongStrings(strings: List[String]): List[String] = {
    strings.filter(_.length > 5)
  }

  def main(args: Array[String]): Unit = {
    val stringList = collectUserInputs()

    val filteredList = filterLongStrings(stringList)

    println("Filtered list (strings with length > 5):")
    println(filteredList)
  }
}
