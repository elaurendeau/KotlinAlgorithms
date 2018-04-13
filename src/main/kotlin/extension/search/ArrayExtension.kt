package extension.search

fun Array<Int>.isSorted(): Boolean = this.asSequence().let { it.zip(it.drop(1)).all { (a, b) -> a < b } }
