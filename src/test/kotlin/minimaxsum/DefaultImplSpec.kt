package minimaxsum

import org.jetbrains.spek.subject.SubjectSpek
import org.jetbrains.spek.subject.itBehavesLike

class MiniMaxSumDefaultImplSpec : SubjectSpek<(Array<Int>) -> Pair<Long, Long>>({
    subject { ::miniMaxSumDefault }

    itBehavesLike(MiniMaxSumFunctionalImplSpec())
})