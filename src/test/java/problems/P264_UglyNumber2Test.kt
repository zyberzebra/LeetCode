package problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class P264_UglyNumber2Test {

    @Test
    fun testExample1() {
        assertThat(nthUglyNumber(10)).isEqualTo(12)
    }

    @Test
    fun testExample2() {
        assertThat(nthUglyNumber(1)).isEqualTo(1)
    }

    @Test
    fun testSmallNumbers() {
        assertThat(nthUglyNumber(2)).isEqualTo(2)
        assertThat(nthUglyNumber(3)).isEqualTo(3)
        assertThat(nthUglyNumber(4)).isEqualTo(4)
        assertThat(nthUglyNumber(5)).isEqualTo(5)
    }

    @Test
    fun testMediumNumbers() {
        assertThat(nthUglyNumber(11)).isEqualTo(15)
        assertThat(nthUglyNumber(15)).isEqualTo(24)
        assertThat(nthUglyNumber(20)).isEqualTo(36)
    }

    @Test
    fun testEdgeCaseLargeNumber() {
        assertThat(nthUglyNumber(1690)).isEqualTo(2123366400)
    }

    @Test
    fun testNonUglyPrimeFactors() {
        // These tests ensure that non-ugly numbers aren't considered as ugly numbers
        assertThat(nthUglyNumber(20)).isNotEqualTo(7)
        assertThat(nthUglyNumber(30)).isNotEqualTo(11)
    }
}