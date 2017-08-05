package comparetriplets

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (a, b) = compare(
            Array<Int>(3, { scan.nextInt() }),
            Array<Int>(3, { scan.nextInt() })
    )
    println("$a $b")
}

fun compare(aliceTriplet: Array<Int>, bobTriplet: Array<Int>) : Pair<Int, Int> {
    TODO("implement method")
}