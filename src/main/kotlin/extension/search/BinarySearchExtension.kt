package extension.search

import constant.AlgorithmConstant

/**
 * Recursive binary search
 * @param array [Array]<[Int]> sorted array
 * @param value [Int] value to search
 * @return [Int] index of the searched value. -1 when the value is not found
 */
fun Array<Int>.binaryIndexOf(value: Int): Int {
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

        if (lowerBound > higherBound) {
            return -1
        }

        val currentIndex = lowerBound + ((higherBound - lowerBound) / 2)
        val currentValue = array[currentIndex]

        return when {
            currentValue == value -> currentIndex
            currentValue < value -> recursiveSearch(array, value, currentIndex + 1, higherBound)
            else -> recursiveSearch(array, value, lowerBound, currentIndex - 1)
        }

    }

    require(this.isSorted()) {AlgorithmConstant.ERROR_MESSAGE_ARRAY_MUST_BE_SORTED}
    return recursiveSearch(this, value, 0, this.size - 1)
}
