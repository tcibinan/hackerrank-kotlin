package diagonaldifference

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val size = scan.nextInt()
    val matrix = Array(size) { Array(size) {scan.nextInt()}}

    println(diagonalAbsoluteDifference(matrix))
}

fun diagonalAbsoluteDifference(matrix: Array<Array<Int>>): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
