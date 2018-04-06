package search.impl

import search.ISearchInterface

/**
 * Recursive binary search
 */
class BinarySearchImpl : ISearchInterface<Int> {
    override fun indexOf(array: Array<Int>, value: Int): Int {
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

            if(lowerBound > higherBound) {
                return -1
            }

            val currentIndex = lowerBound + ((higherBound - lowerBound) / 2)
            val currentValue = array[currentIndex]

            return when {
                currentValue == value -> currentIndex
                currentValue < value -> recursiveSearch(array, value, currentIndex+1, higherBound)
                else -> recursiveSearch(array, value, lowerBound, currentIndex-1)
            }

        }

        return recursiveSearch(array, value,0, array.size-1)
    }
}