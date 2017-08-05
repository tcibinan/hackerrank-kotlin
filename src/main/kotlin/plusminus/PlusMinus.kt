package plusminus

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nums = Array(scan.nextInt()) { scan.nextInt() }

    plusMinusZeros(nums).toList().forEach(::println)
}

fun plusMinusZeros(nums: Array<Int>): Triple<Double, Double, Double> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
