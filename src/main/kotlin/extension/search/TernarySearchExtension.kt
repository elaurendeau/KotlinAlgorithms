package extension.search

import constant.AlgorithmConstant
import extension.isSorted

/**
 * A ternary search determines either that the minimum or maximum cannot be in the first third of the domain or that it cannot be in the last third of the domain, then repeats on the remaining third
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

        val middleLowerBound = lowerBound + ((higherBound - lowerBound) / 3)
        val middleHigherBound = higherBound - ((higherBound - lowerBound) / 3)

        return when {
            array[higherBound] < value -> -1
            array[lowerBound] > value -> -1
            array[higherBound] == value -> higherBound
            array[middleHigherBound] < value -> recursiveSearch(array, value, middleHigherBound+1, higherBound)
            array[middleHigherBound] == value -> middleHigherBound
            array[middleLowerBound] < value -> recursiveSearch(array, value, middleLowerBound+1, middleHigherBound)
            array[middleLowerBound] == value -> middleLowerBound
            else -> recursiveSearch(array, value, lowerBound, middleLowerBound)
        }

    }

    require(this.isSorted()) {AlgorithmConstant.ERROR_MESSAGE_ARRAY_MUST_BE_SORTED}
    return recursiveSearch(this, value, 0, this.size - 1)
}
