package extension

/**
 * Function used to know if an array is sorted
 * @return true when sorted
 */
fun Array<Int>.isSorted(): Boolean = this.asSequence().let { it.zip(it.drop(1)).all { (a, b) -> a < b } }
