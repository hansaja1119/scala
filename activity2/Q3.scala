object Q3 {
  def basik(normalWorkingHrs: Int) = normalWorkingHrs * 250
  def ot(otHrs: Int) = otHrs * 85

  def totalSalary(normalWorkingHrs: Int, otHrs: Int) =
    basik(normalWorkingHrs) + ot(otHrs)

  def tax(normalWorkingHrs: Int, otHrs: Int) = if (
    totalSalary(normalWorkingHrs, otHrs) >= totalSalary(40, 30)
  ) totalSalary(normalWorkingHrs, otHrs) * 0.12
  else 0

  def takeHomeSalary(normalWorkingHrs: Int, otHrs: Int) =
    totalSalary(normalWorkingHrs, otHrs) - tax(normalWorkingHrs, otHrs)

  def main(args: Array[String]): Unit = {
    val normalHrs = 40
    val otHrs = 30
    println("Take Home Salary: " + takeHomeSalary(normalHrs, otHrs))
  }
}
