object Q1 {
  def main() = {

    // var k = i = j = 2
    // var m = n = 5
    // cant assign in same line

    var i = 2
    var j = 2
    var k = 2
    var m = 5
    var n = 5
    var f = 12.0f
    var g = 4.0f
    var c = 'X'

    println(s"k + 12*m = ${k + 12 * m}")
    println(s"m/j = ${m / j}")
    println(s"n%j = ${n % j}")
    println(s"m/j*j = ${m / j * j}")

    println(s"f + 10*5 + c = ${f + 10 * 5 + c}")
    // 12.0f + 50 + 'X' (ASCII 88) = 150.0

    println(s"(i + 1) * n = ${(i + 1) * n}")
    // println(s"++i * n = ${++ i * n}")    - > ++ doesnt support
  }
}
