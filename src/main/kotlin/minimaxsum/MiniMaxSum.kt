package minimaxsum

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val (a, b) = miniMaxSumFunctional(Array(5) { scanner.nextInt() })
    println("$a $b")
}

fun miniMaxSumFunctional(nums: Array<Int>): Pair<Long, Long> =
        nums.sortedArray().foldIndexed(Pair(0L, 0L)) { index, acc, int ->
            if (index == 0) Pair(int.toLong(), 0L)
            else if (index == nums.size - 1) Pair(acc.first, acc.second + int)
            else Pair(acc.first + int, acc.second + int)
        }

fun miniMaxSumDefault(nums: Array<Int>) : Pair<Long, Long> {
    val sortedArray = nums.sortedArray().map(Int::toLong)
    val sum = sortedArray.sum()

    return Pair(sum - sortedArray.last(), sum - sortedArray.first())
}