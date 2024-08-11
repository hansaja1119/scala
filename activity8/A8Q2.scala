import scala.io.StdIn.readLine

object A8Q2 {
  val alphabet = "abcdefghijklmnopqrstuvwxyz"
  val shiftValue = 3

  def caesarCipherEncryption(msg: String): String = {
    val encrypted = msg.map(c => {
      val index = alphabet.indexOf(c.toLower)
      if (index == -1) c
      else {
        val newIndex = (index + shiftValue) % 26
        if (c.isUpper) alphabet(newIndex).toUpper else alphabet(newIndex)
      }
    })

    encrypted
  }

  def caesarCipherDecryption(msg: String): String = {
    val decrypted = msg.map(c => {
      val index = alphabet.indexOf(c.toLower)
      if (index == -1) c
      else {
        val newIndex = (index - shiftValue) % 26
        if (c.isUpper) alphabet(newIndex).toUpper else alphabet(newIndex)
      }
    })

    decrypted
  }

  def caesarCipher(msg: String, mode: Int): Unit = {
    if (mode == 1) {
      println("Encrypted text : " + caesarCipherEncryption(msg))
    } else {
      println("Decrypted text : " + caesarCipherDecryption(msg))
    }
  }

  def main(args: Array[String]): Unit = {
    val msg = readLine("Enter the text : ")
    val mode = readLine("To encrypt Enter 1 & to decrypt enter 0 : ").toInt

    caesarCipher(msg, mode)
  }
}
