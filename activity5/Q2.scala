import scala.io.StdIn.readLine

case class Book(title: String, author: String, isbn: String)

object Q2 {
  var library: Set[Book] = Set(
    Book("Welcome to MERN", "Anushka Liynage", "9780743273565"),
    Book("250", "Arther C. Clark", "9780451524935"),
    Book("Drugs", "Harper Lee", "9780061120084")
  )

  def addBook(book: Book): Unit = {
    if (!library.exists(_.isbn == book.isbn)) {
      library += book
      println(s"Book added: ${book.title} by ${book.author}")
    } else {
      println("A book with this ISBN already exists in the library.")
    }
  }

  def removeBook(isbn: String): Unit = {
    if (checkBook(isbn)) {
      library = library.filterNot(_.isbn == isbn)
      println(s"Book with ISBN $isbn removed from the library.")
    } else {
      println("No book with this ISBN found in the library.")
    }
  }

  def checkBook(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach(book =>
      println(
        s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"
      )
    )
  }

  def searchByTitle(title: String): Unit = {
    val foundBooks = library.filter(_.title.equalsIgnoreCase(title))
    if (foundBooks.nonEmpty) {
      foundBooks.foreach(book =>
        println(
          s"Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"
        )
      )
    } else {
      println("No book found with that title.")
    }
  }

  def displayByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      )
    } else {
      println(s"No books found by $author.")
    }
  }

  def main(args: Array[String]): Unit = {
    var continue = true

    while (continue) {
      println("\nLibrary Management System")
      println("1. Display Library Collection")
      println("2. Add a New Book")
      println("3. Remove a Book by ISBN")
      println("4. Check if a Book is in the Library by ISBN")
      println("5. Search for a Book by Title")
      println("6. Display All Books by an Author")
      println("7. Exit")

      print("Choose an option: ")
      val choice = readLine().toInt

      choice match {
        case 1 => displayLibrary()
        case 2 =>
          print("Enter book title: ")
          val title = readLine()
          print("Enter book author: ")
          val author = readLine()
          print("Enter book ISBN: ")
          val isbn = readLine()
          addBook(Book(title, author, isbn))
        case 3 =>
          print("Enter book ISBN to remove: ")
          val isbn = readLine()
          removeBook(isbn)
        case 4 =>
          print("Enter book ISBN to check: ")
          val isbn = readLine()
          if (checkBook(isbn)) {
            println("The book is in the library.")
          } else {
            println("The book is not in the library.")
          }
        case 5 =>
          print("Enter book title to search: ")
          val title = readLine()
          searchByTitle(title)
        case 6 =>
          print("Enter author name to search: ")
          val author = readLine()
          displayByAuthor(author)
        case 7 => continue = false
        case _ => println("Invalid option. Please try again.")
      }
    }
  }
}
