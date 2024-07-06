import scala.io.StdIn.readLine

object Q1 {
  def collectItemNames(): List[String] = {
    println("Enter items one by one, and type 'done' when finished:")

    var input = ""
    var list = List[String]()
    while (input != "done") {
      input = readLine()
      if (input != "done" && input != "done") {
        list = list :+ input
      }
    }
    list
  }

  def collectItemCount(items: List[String]): List[Int] = {
    println(
      "Enter count of each item one by one:"
    )

    var input = ""
    var count = List[Int]()
    for (i <- 0 until items.length) {
      input = readLine()
      try {
        count = count :+ input.toInt
      } catch {
        case _: NumberFormatException =>
          println("Please enter a valid integer.")

      }
    }
    count
  }

  def displayInventory(items: List[String], quantity: List[Int]): Unit = {
    println("Inventory:")
    for (i <- 0 until items.length) {
      println(items(i) + ": " + quantity(i))
    }
  }

  def restockItem(items: List[String], quantities: List[Int]): List[Int] = {
    println("Enter the item name to restock:")
    val item = readLine()
    val index = items.indexOf(item)
    if (index >= 0) {
      println("Enter the quantity to restock:")
      try {
        val restockQty = readLine().toInt
        val updatedQuantities =
          quantities.updated(index, quantities(index) + restockQty)
        println(s"$restockQty units of $item restocked.")
        updatedQuantities
      } catch {
        case _: NumberFormatException =>
          println("Invalid quantity entered. No changes made.")
          quantities
      }
    } else {
      println("Item not found.")
      quantities
    }
  }

  def sellItem(items: List[String], quantities: List[Int]): List[Int] = {
    println("Enter the item name to sell:")
    val item = readLine()
    val index = items.indexOf(item)
    if (index >= 0) {
      println("Enter the quantity to sell:")
      try {
        val sellQty = readLine().toInt
        if (sellQty <= quantities(index)) {
          val updatedQuantities =
            quantities.updated(index, quantities(index) - sellQty)
          println(s"$sellQty units of $item sold.")
          updatedQuantities
        } else {
          println("Insufficient stock. No changes made.")
          quantities
        }
      } catch {
        case _: NumberFormatException =>
          println("Invalid quantity entered. No changes made.")
          quantities
      }
    } else {
      println("Item not found.")
      quantities
    }
  }

  def main(args: Array[String]): Unit = {
    var items = collectItemNames()
    var quantities = collectItemCount(items)

    displayInventory(items, quantities)

    quantities = restockItem(items, quantities)
    displayInventory(items, quantities)

    quantities = sellItem(items, quantities)
    displayInventory(items, quantities)
  }
}
