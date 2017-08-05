package verybigsum

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import verybigsum.sum
import kotlin.test.assertEquals

object VeryBigSumSpec : Spek({
    describe("a very big sum calculation") {
        val sumFunction = ::sum

        on("very big ints") {
            val s = sumFunction(arrayOf(1000000001, 1000000002, 1000000003, 1000000004, 1000000005))

            it("should return big value") {
                assertEquals(5000000015, s)
            }
        }

        on("small ints") {
            val s = sumFunction(arrayOf(1, 2, 3))

            it("should return small value") {
                assertEquals(6, s)
            }
        }
    }
})