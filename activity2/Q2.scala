object Q2 {
  def main(args: Array[String]): Unit = {
    // int a = 2, b = 3, c = 4, d = 5;
    // float k = 4.3f;

    var a = 2
    var b = 3
    var c = 4
    var d = 5
    var k = 4.3f

    // println( - -b * a + c * d - -);
    println(-(-b) * a + c * d)

    // println(a++);
    println(a)
    a += 1

    // println(–2 * (g – k) + c);
    var g = 2.0f
    println(-2 * (g - k) + c)

    // println(c = c++);
    println(c)
    c += 1

    // println(c = ++c * a++);
    a += 1
    c += 1
    println(c * a) // Corrected version
  }
}
