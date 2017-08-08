package comparetriplets

import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.data_driven.data
import org.jetbrains.spek.data_driven.on
import org.jetbrains.spek.subject.SubjectSpek
import kotlin.test.assertEquals

object CompareTripletsSpec : SubjectSpek<(Array<Int>, Array<Int>) -> Pair<Int, Int>>({
    describe("a triplets comparator") {
        subject { ::compareTriplets }

        val dataWithTriplets = arrayOf(
                data("10, 20, 30", "10, 20, 30",
                        Pair(arrayOf(10, 20, 30), arrayOf(10, 20, 30)),
                        expected = Pair(0,0)),
                data("100, 100, 100", "10, 10, 10",
                        Pair(arrayOf(100, 100, 100), arrayOf(10, 10, 10)),
                        expected = Pair(3,0)),
                data("100, 10, 10", "10, 100, 100",
                        Pair(arrayOf(100, 10, 10), arrayOf(10, 100, 100)),
                        expected = Pair(1,2))
        )

        on("triplets %s for Alice and %s for Bob",
                *dataWithTriplets) { _, _, (aliceTriplet, bobTriplet), (first, second) ->
            val (alice, bob) = subject(aliceTriplet, bobTriplet)

            it("should give Alice ${first} points") {
                assertEquals(first, alice)
            }

            it("should give Bob ${second} points") {
                assertEquals(second, bob)
            }
        }
    }
})