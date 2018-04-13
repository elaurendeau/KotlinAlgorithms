package extension.search

import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LinearSearchExtensionTest {

    @Test
    fun `linearSearchIndexOf return -1 on value bigger than highest value`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40)

        Assert.assertEquals(-1, array.linearSearchIndexOf(100))
    }

    @Test
    fun `linearSearchIndexOf return -1 on value smaller than smallest number`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40)

        Assert.assertEquals(-1, array.linearSearchIndexOf(0))
    }

    @Test
    fun `linearSearchIndexOf return valid index on first value`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40)

        Assert.assertEquals(0, array.linearSearchIndexOf(2))
    }

    @Test
    fun `linearSearchIndexOf return valid index on value in the middle of an odd array`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 15, 20, 30, 40)

        Assert.assertEquals(3, array.linearSearchIndexOf(15))
    }

    @Test
    fun `linearSearchIndexOf return valid index on value in the middle of an even array`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40)

        Assert.assertEquals(2, array.linearSearchIndexOf(10))
        Assert.assertEquals(3, array.linearSearchIndexOf(20))
    }

}