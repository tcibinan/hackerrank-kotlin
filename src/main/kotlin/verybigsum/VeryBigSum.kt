package verybigsum

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nums = Array(scan.nextInt(), {scan.nextInt()})

    println(sum(nums))
}

fun sum(nums: Array<Int>) : Long = nums.fold(0L) { l, i -> l+i}