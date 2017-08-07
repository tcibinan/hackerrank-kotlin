package minimaxsum

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val (a, b) = miniMaxSum(Array(5) { scanner.nextInt() })
    println("$a $b")
}

fun miniMaxSum(nums : Array<Int>) : Pair<Long, Long> {
    TODO("Implement")
}