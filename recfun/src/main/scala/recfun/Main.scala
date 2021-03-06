package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0)
      1
    else if (c == r)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def value(char: Char, count: Int): Int = {
      if (char == '(')
        count + 1
      else if (char == ')')
        count - 1
      else
        count
    }
    def balanceWithCount(chars: List[Char], count: Int): Boolean = {
      if (chars.isEmpty)
        count == 0
      else if (count < 0)
        false
      else
        balanceWithCount(chars.tail, value(chars.head, count))
    }
    balanceWithCount(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def count(money: Int, coins: List[Int]): Int = {
      if (money == 0)
        1
      else if (money < 0)
        0
      else if (coins.isEmpty && money >= 1)
        0
      else
        count(money, coins.tail) + count(money - coins.head, coins)
    }
    count(money, coins)
  }
}
