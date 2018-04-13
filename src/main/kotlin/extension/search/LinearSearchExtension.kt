package extension.search

/**
 * Linear search.
 * @param array [Array]<[Int]> array
 * @param value [Int] value to search
 * @return [Int] index of the searched value. -1 when the value is not found
 */
fun Array<Int>.linearSearchIndexOf(value: Int): Int {
    run breaker@{
        this.forEachIndexed { index, i ->
            if(i == value) {
                return index
            }
        }

        return -1
    }
}
