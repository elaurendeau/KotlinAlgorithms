package search

/**
 * Search interface. All search algorithms should implement this interface
 */
interface ISearchInterface<T> {

    /**
     * Search the [Array] for the value
     * @param array [Array]<[T]> with all possible values
     * @param value [T] to be searched
     * @return index within the array or -1 when not found
     */
    fun indexOf(array: Array<T>, value: T): Int
}