package plusminus

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nums = Array(scan.nextInt()) { scan.nextInt() }

    plusMinusZeros(nums).toList().forEach { println { "%.6d".format(it) } }
}

fun plusMinusZeros(nums: Array<Int>): Triple<Double, Double, Double> =
        nums
                .fold(Triple(0.0, 0.0, 0.0)) { acc, num ->
                    if (num > 0)
                        Triple(acc.first + 1, acc.second, acc.third)
                    else if (num < 0)
                        Triple(acc.first, acc.second + 1, acc.third)
                    else
                        Triple(acc.first, acc.second, acc.third + 1)
                }
                .let {
                    val size = if (nums.isEmpty()) 1 else nums.size
                    Triple(it.first / size, it.second / size, it.third / size)
                }

