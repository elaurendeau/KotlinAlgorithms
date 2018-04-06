import search.ISearchInterface
import search.impl.BinarySearchImpl

class Application {
       companion object {

        @JvmStatic fun main(args: Array<String>) {
            val searcher: ISearchInterface<Int> = BinarySearchImpl()

            val array: Array<Int> = arrayOf(10, 20, 30, 40, 5,  2).sortedArray()
            println("====Sorted Array====")
            array.forEach { x -> print("" + x + " ") }

            val value = 30
            println("\nValue: " + value + " found at index: " + searcher.indexOf(array, value))
        }
    }
}