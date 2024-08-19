object A9Q3 {
  def toUpper(str: String): String = str.toUpperCase

  def toLower(str: String): String = str.toLowerCase

  def formatName(name: String, formatType: Int): String = {
    formatType match {
      case 1 => toUpper(name)
      case 2 => toUpper(name.take(2)) + toLower(name.drop(2))
      case 3 => toLower(name)
      case 4 =>
        toUpper(name.take(1)) + toLower(name.drop(1).dropRight(1)) + toUpper(
          name.takeRight(1)
        )
      case _ => name
    }
  }

  def main(args: Array[String]): Unit = {
    val names = List("Benny", "Niroshan", "Saman", "Kumara")
    val formatTypes = List(1, 2, 3, 4)

    for ((name, formatType) <- names.zip(formatTypes)) {
      println(formatName(name, formatType))
    }
  }
}
