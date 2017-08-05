package arraysum

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.*

object ArraySumSpec : Spek({
    describe("a sum function") {
        val sumFunction = ::sum

        on("non empty array") {
            val sum = sumFunction(arrayOf(5, 6, 7))
            it("should return sum of elements") {
                assertEquals(sum, 18)
            }
        }

        on("empty array") {
            val sum = sumFunction(arrayOf())
            it("should return 0") {
                assertEquals(sum, 0)
            }
        }
    }
})