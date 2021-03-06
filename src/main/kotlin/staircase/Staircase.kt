package staircase

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    println(getStaircase(n))
}

fun getStaircase(stairs: Int): String {
    return (1..stairs)
            .fold(StringBuilder()) { sb, i ->
                sb.append("${" ".repeat(stairs - i)}${"#".repeat(i)}\n")
            }
            .removeSuffix("\n")
            .toString()
}
