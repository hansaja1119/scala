object Q4 {
  def expectedAttendees(ticketPrice: Int): Int = ticketPrice match {
    case 15 => 120
    case _ if ticketPrice < 15 =>
      120 + (15 - ticketPrice) / 5 * 20
    case _ if ticketPrice > 15 =>
      120 - (ticketPrice - 15) / 5 * 20
  }

  def cost(totalAttendees: Int): Int = 500 + 3 * totalAttendees

  def profit(ticketPrice: Int): Int =
    ticketPrice * expectedAttendees(ticketPrice) - cost(
      expectedAttendees(ticketPrice)
    )

  def maxPrice(ticketPrice: Int): Int = {
    val currentProfit = profit(ticketPrice)
    val profitIfIncreased = profit(ticketPrice + 5)
    val profitIfDecreased = profit(ticketPrice - 5)

    (currentProfit, profitIfIncreased, profitIfDecreased) match {
      case (c, i, d) if c > i && c > d => ticketPrice
      case (c, i, d) if i > c && i > d => maxPrice(ticketPrice + 5)
      case (c, i, d) if d > c && d > i => maxPrice(ticketPrice - 5)
    }
  }

  def main(args: Array[String]): Unit = {
    println(s"Best ticket price is ${maxPrice(15)}")
  }
}
