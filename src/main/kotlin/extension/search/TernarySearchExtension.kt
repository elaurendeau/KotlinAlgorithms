package extension.search

import constant.AlgorithmConstant
import extension.isSorted

/**
 * Recursive ternary search
 * @param array [Array]<[Int]> sorted array
 * @param value [Int] value to search
 * @return [Int] index of the searched value. -1 when the value is not found
 */
fun Array<Int>.ternarySearchIndexOf(value: Int): Int {
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

        val middleLowerBound = lowerBound + ((higherBound - lowerBound) / 3)
        val middleLowerValue = array[middleLowerBound]
        val middleHigherBound = lowerBound + middleLowerBound
        val middleHigherValue = array[middleHigherBound]
        val higherValue = array[higherBound]
        val lowerValue = array[lowerBound]


        return when {
            higherValue < value -> -1
            higherValue == value -> higherBound
            middleHigherBound < value -> recursiveSearch(array, value, middleHigherBound+1, higherBound)
            middleHigherValue == value -> middleHigherBound
            middleLowerValue < value -> recursiveSearch(array, value, middleLowerBound+1, middleHigherBound)
            middleLowerValue == value -> middleLowerBound
            lowerValue > value -> -1
            else -> recursiveSearch(array, value, lowerBound, middleLowerBound)

        }

    }

    require(this.isSorted()) {AlgorithmConstant.ERROR_MESSAGE_ARRAY_MUST_BE_SORTED}
    return recursiveSearch(this, value, 0, this.size - 1)
}
