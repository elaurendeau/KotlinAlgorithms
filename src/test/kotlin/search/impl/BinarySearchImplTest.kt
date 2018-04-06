package search.impl

import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class BinarySearchImplTest {

    private lateinit var binarySearch: BinarySearchImpl

    @BeforeEach
    fun init() {
        binarySearch = BinarySearchImpl()
    }

    @Test
    fun `indexOf return -1 on value bigger than highest value`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40).sortedArray()

        Assert.assertEquals(-1, binarySearch.indexOf(array, 100))
    }

    @Test
    fun `indexOf return -1 on value smaller than smallest number`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40).sortedArray()

        Assert.assertEquals(-1, binarySearch.indexOf(array, 0))
    }

    @Test
    fun `indexOf return valid index on first value`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40).sortedArray()

        Assert.assertEquals(0, binarySearch.indexOf(array, 2))
    }

    @Test
    fun `indexOf return valid index on value in the middle of an odd array`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 15, 20, 30, 40).sortedArray()

        Assert.assertEquals(3, binarySearch.indexOf(array, 15))
    }

    @Test
    fun `indexOf return valid index on value in the middle of an even array`() {
        val array: Array<Int> = arrayOf(2, 5, 10, 20, 30, 40).sortedArray()

        Assert.assertEquals(2, binarySearch.indexOf(array, 10))
        Assert.assertEquals(3, binarySearch.indexOf(array, 20))
    }

}