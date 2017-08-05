package comparetriplets

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object CompareTripletsSpec : Spek ({
    describe("a triplets comparator") {
        val compareTriplets = ::compare

        on("equivalent results in every category") {
            val (alice, bob) = compareTriplets(arrayOf(5, 10, 15), arrayOf(5, 10, 15))

            it("should give Alice's 0 points") {
                assertEquals(0, alice)
            }

            it("should give Bob's 0 points") {
                assertEquals(0, bob)
            }
        }

        on("Alice win in every category") {
            val (alice, bob) = compareTriplets(arrayOf(10, 20, 30), arrayOf(5, 15, 25))

            it("should give Alice all points") {
                assertEquals(3, alice)
            }

            it("should give Bob no points") {
                assertEquals(0, bob)
            }
        }

        on("Alice win in one category and Bob win in two categories") {
            val (alice, bob) = compareTriplets(arrayOf(20, 10, 10), arrayOf(10, 20, 20))

            it("should give Alice 1 point") {
                assertEquals(1, alice)
            }

            it("should give Bob 2 points") {
                assertEquals(2, bob)
            }
        }
    }
})