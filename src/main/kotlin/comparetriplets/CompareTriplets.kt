package comparetriplets

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (a, b) = compare(
            Array(3, { scan.nextInt() }),
            Array(3, { scan.nextInt() })
    )
    println("$a $b")
}

fun compare(aliceTriplet: Array<Int>, bobTriplet: Array<Int>): Pair<Int, Int> {
    var alice = 0
    var bob = 0
    for (i in 0..2) {
        if (aliceTriplet[i] > bobTriplet[i])
            alice++
        else if (aliceTriplet[i] < bobTriplet[i])
            bob++
    }
    return Pair(alice, bob)
}