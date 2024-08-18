package problems

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