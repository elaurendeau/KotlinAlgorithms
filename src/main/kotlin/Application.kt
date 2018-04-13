
import extension.search.binaryIndexOf

class Application {
       companion object {

        @JvmStatic fun main(args: Array<String>) {

            val array: Array<Int> = arrayOf(10, 20, 30, 40, 5,  2).sortedArray()

            array.asSequence()
            println("====Sorted Array====")
            array.forEach { x -> print("" + x + " ") }

            val value = 30
            println("\nValue: " + value + " found at index: " + array.binaryIndexOf(value))
        }
    }
}