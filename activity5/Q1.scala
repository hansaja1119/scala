import scala.io.StdIn.readLine

object Q1 {
  def getProductList(): List[String] = {
    println("Enter product names one by one, and type 'done' when finished:")

    var input = ""
    var productList = List[String]()
    while (input != "done") {
      input = readLine()
      if (input != "done" && input.nonEmpty) {
        productList = productList :+ input
      }
    }
    productList
  }

  def printProductList(products: List[String]): Unit = {
    println("Product List:")
    for ((product, index) <- products.zipWithIndex) {
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  def main(args: Array[String]): Unit = {
    val products = getProductList()
    printProductList(products)
    val totalProducts = getTotalProducts(products)
    println(s"Total number of products: $totalProducts")
  }
}
