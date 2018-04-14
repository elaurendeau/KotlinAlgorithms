package extension.search

import constant.AlgorithmConstant
import extension.isSorted

/**
 * Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval covering the whole array. If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half.
 * @param array [Array]<[Int]> sorted array
 * @param value [Int] value to search
 * @return [Int] index of the searched value. -1 when the value is not found
 */
fun Array<Int>.binarySearchIndexOf(value: Int): Int {
    /**
     * Recursive method to search. Each pass of the method should reduce the query range by half.
     *
     * @param array [Array]<[Int]>
     * @param value [Int] value to search
     * @param lowerBound [Int] index lower bound. Initial value should always start at 0
     * @param higherBound [Int] index higher bound. Initial value should be array.size - 1
     *
     * @return [Int] index
     */
    fun recursiveSearch(array: Array<Int>, value: Int, lowerBound: Int, higherBound: Int): Int {

        val currentIndex = lowerBound + ((higherBound - lowerBound) / 2)

        return when {
            array[higherBound] < value -> -1
            array[lowerBound] > value -> -1
            array[currentIndex] < value -> recursiveSearch(array, value, currentIndex + 1, higherBound)
            array[currentIndex] == value -> currentIndex
            else -> recursiveSearch(array, value, lowerBound, currentIndex - 1)
        }

    }

    require(this.isSorted()) {AlgorithmConstant.ERROR_MESSAGE_ARRAY_MUST_BE_SORTED}
    return recursiveSearch(this, value, 0, this.size - 1)
}
