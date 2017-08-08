package comparetriplets

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val (a, b) = compareTriplets(
            Array(3, { scan.nextInt() }),
            Array(3, { scan.nextInt() })
    )
    println("$a $b")
}

fun compareTriplets(aliceTriplet: Array<Int>, bobTriplet: Array<Int>): Pair<Int, Int> =
        aliceTriplet
                .mapIndexed { i, a -> Pair(a, bobTriplet[i]) }
                .fold(Pair(0, 0)) { acc, pair ->
                    acc.copy(
                            if (pair.first > pair.second) acc.first + 1 else acc.first,
                            if (pair.first < pair.second) acc.second + 1 else acc.second
                    )
                }