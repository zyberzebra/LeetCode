package problems

import java.util.*
import kotlin.collections.HashSet

class P264_UglyNumber2

fun nthUglyNumber(n: Int): Int {
    if (n == 1) return 1
    var foundNumbers = 1
    var index = 1
    while (foundNumbers != n) {
        index++
        var indexCopy = index

        for (i in intArrayOf(2, 3, 5)) {
            while (indexCopy % i == 0) {
                indexCopy /= i
            }
        }
        if (indexCopy == 1) {
            foundNumbers++
        }
    }
    return index
}

fun nthUglyNumberButFaster(n: Int): Int {
    val factors = intArrayOf(2, 3, 5)
    val heap = PriorityQueue<Long>()
    val seen = HashSet<Long>()

    heap.add(1L)
    seen.add(1L)

    var ugly: Long

    for (i in 1 until n) {
        ugly = heap.poll()

        for (factor in factors) {
            val newUgly = ugly * factor
            if (seen.add(newUgly)) {
                heap.add(newUgly)
            }
        }
    }

    return heap.poll().toInt()
}