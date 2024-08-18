package problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class P264_UglyNumber2Test {

    val futFast = { n: Int -> nthUglyNumberButFaster(n) }
    val futSlow = { n: Int -> nthUglyNumber(n) }


    @Nested
    inner class P624Tests(){

        private val fut = futFast

    @Test
    fun testExample1() {
        assertThat(fut(10)).isEqualTo(12)
    }

    @Test
    fun testExample2() {
        assertThat(fut(1)).isEqualTo(1)
    }

    @Test
    fun testSmallNumbers() {
        assertThat(fut(2)).isEqualTo(2)
        assertThat(fut(3)).isEqualTo(3)
        assertThat(fut(4)).isEqualTo(4)
        assertThat(fut(5)).isEqualTo(5)
    }

    @Test
    fun testMediumNumbers() {
        assertThat(fut(11)).isEqualTo(15)
        assertThat(fut(15)).isEqualTo(24)
        assertThat(fut(20)).isEqualTo(36)
    }

    @Test
    fun testEdgeCaseLargeNumber() {
        assertThat(fut(1690)).isEqualTo(2123366400)
    }

    @Test
    fun testNonUglyPrimeFactors() {
        // These tests ensure that non-ugly numbers aren't considered as ugly numbers
        assertThat(fut(20)).isNotEqualTo(7)
        assertThat(fut(30)).isNotEqualTo(11)
    }
    }
}