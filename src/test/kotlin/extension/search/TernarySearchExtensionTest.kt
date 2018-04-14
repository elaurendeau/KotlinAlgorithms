package extension.search

import constant.AlgorithmConstant
import org.junit.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class TernarySearchExtensionTest {

    @Test
    fun `ternarySearchIndexOf return an exception when the array is unsorted`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            arrayOf(25, 5, 10, 20, 30, 40).ternarySearchIndexOf(30)
        }
        Assertions.assertEquals(AlgorithmConstant.ERROR_MESSAGE_ARRAY_MUST_BE_SORTED, exception.message)
    }

    @Test
    fun `ternarySearchIndexOf return -1 on value bigger than highest value`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40).sortedArray()

        Assert.assertEquals(-1, array.ternarySearchIndexOf(100))
    }

    @Test
    fun `ternarySearchIndexOf return -1 on value smaller than smallest number`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40).sortedArray()

        Assert.assertEquals(-1, array.ternarySearchIndexOf(0))
    }

    @Test
    fun `ternarySearchIndexOf return valid index on first value`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40).sortedArray()

        Assert.assertEquals(0, array.ternarySearchIndexOf(2))
    }

    @Test
    fun `ternarySearchIndexOf return valid index on value in the middle of an odd array`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 15, 20, 30, 40).sortedArray()

        Assert.assertEquals(3, array.ternarySearchIndexOf(15))
    }

    @Test
    fun `ternarySearchIndexOf return valid index on value in the middle of an even array`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40).sortedArray()

        Assert.assertEquals(2, array.ternarySearchIndexOf(10))
        Assert.assertEquals(3, array.ternarySearchIndexOf(20))
    }

}