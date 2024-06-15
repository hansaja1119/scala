object BookPrice {
  def total(n: Int): Double = n * 24.95
  def discount(total: Double): Double = total * 0.4
  def shipping(n: Int): Double = if (n > 50) 50 * 3 + (n - 50) * 0.75 else n * 3
  def cost(n: Int): Double = total(n) - discount(total(n)) + shipping(n)

  def main(args: Array[String]): Unit = {
    val bookCount = 60
    val finalCost = cost(bookCount)
    println(s"Final cost for $bookCount books is $finalCost")
  }
}
