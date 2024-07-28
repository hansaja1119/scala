import scala.io.StdIn.readLine

object Q2Student {

  def validateInput(
      name: String,
      marks: Int,
      totalMarks: Int
  ): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (marks < 0 || marks > totalMarks) {
      (
        false,
        Some(
          "Marks should be positive and not exceed the total possible marks."
        )
      )
    } else {
      (true, None)
    }
  }

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    println("Enter student's name:")
    val name = readLine()
    println("Enter student's marks:")
    val marks = readLine().toInt
    println("Enter total possible marks:")
    val totalMarks = readLine().toInt

    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _            => 'D'
    }

    (name, marks, totalMarks, percentage, grade)
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var valid = false
    var studentInfo: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'F')

    while (!valid) {
      val (name, marks, totalMarks, percentage, grade) = getStudentInfo()
      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)
      if (isValid) {
        valid = true
        studentInfo = (name, marks, totalMarks, percentage, grade)
      } else {
        println(s"Invalid input: ${errorMessage.get}")
      }
    }

    studentInfo
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks: $marks / $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }
}
