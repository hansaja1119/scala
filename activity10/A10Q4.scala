object BankApp {

  class Account(val accountNumber: String, initialBalance: Double) {
    private var balance: Double = initialBalance

    def deposit(amount: Double): Unit = {
      if (amount > 0) {
        balance += amount
        println(
          s"Deposited $$${amount} into account $accountNumber. New balance: $$${balance}"
        )
      } else {
        println(
          s"Deposit amount must be positive. Provided amount: $$${amount}"
        )
      }
    }

    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        println(
          s"Withdrew $$${amount} from account $accountNumber. New balance: $$${balance}"
        )
      } else if (amount > balance) {
        println(
          s"Insufficient funds in account $accountNumber. Available balance: $$${balance}"
        )
      } else {
        println(
          s"Withdrawal amount must be positive. Provided amount: $$${amount}"
        )
      }
    }

    def transfer(amount: Double, toAccount: Account): Unit = {
      if (amount > 0 && amount <= balance) {
        this.withdraw(amount)
        toAccount.deposit(amount)
        println(
          s"Transferred $$${amount} from account $accountNumber to account ${toAccount.accountNumber}."
        )
      } else if (amount > balance) {
        println(
          s"Insufficient funds in account $accountNumber to transfer $$${amount}. Available balance: $$${balance}"
        )
      } else {
        println(
          s"Transfer amount must be positive. Provided amount: $$${amount}"
        )
      }
    }

    def applyInterest(): Unit = {
      if (balance > 0) {
        balance += balance * 0.05
      } else {
        balance += balance * 0.1
      }
    }

    def getBalance: Double = balance

    override def toString: String =
      s"Account Number: $accountNumber, Balance: $$${balance}"
  }

  type Bank = List[Account]

  def accountsWithNegativeBalances(bank: Bank): List[Account] = {
    bank.filter(_.getBalance < 0)
  }

  def calculateTotalBalance(bank: Bank): Double = {
    bank.map(_.getBalance).sum
  }

  def applyInterestToAllAccounts(bank: Bank): Unit = {
    bank.foreach(_.applyInterest())
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account("0073516329", 10000.0)
    val account2 = new Account("80012745178", -5000.0)
    val account3 = new Account("12315754525", 2000.0)
    val account4 = new Account("679436890075", -1500.0)

    val bank: Bank = List(account1, account2, account3, account4)

    println("Initial state of the bank:")
    bank.foreach(println)

    val negativeAccounts = accountsWithNegativeBalances(bank)
    println("\nAccounts with negative balances:")
    negativeAccounts.foreach(println)

    val totalBalance = calculateTotalBalance(bank)
    println(s"\nTotal balance of all accounts: $$${totalBalance}")

    applyInterestToAllAccounts(bank)
    println("\nFinal state of the bank after applying interest:")
    bank.foreach(println)
  }
}
