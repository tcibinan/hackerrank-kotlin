package diagonaldifference

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val size = scan.nextInt()
    val matrix = Array(size) { Array(size) { scan.nextInt() } }

    println(diagonalAbsoluteDifference(matrix))
}

fun diagonalAbsoluteDifference(matrix: Array<Array<Int>>): Int {
    return matrix
            .foldIndexed(Pair(0, 0)) { i, acc, array ->
                Pair(acc.first + array[i], acc.second + array[array.size - 1 - i]) }
            .let { Math.abs(it.first - it.second) }
}
