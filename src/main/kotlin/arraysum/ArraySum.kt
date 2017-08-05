package arraysum

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    var list = Array<Int>(n, {scanner.nextInt()})
    println(sum(list))
}

fun sum(list : Array<Int>) : Int = list.sum()