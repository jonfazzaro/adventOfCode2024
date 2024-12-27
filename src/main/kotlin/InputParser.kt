class InputParser(input: String) {

    val lists: List<List<Int>> = listOf(
        parseList(input, 0),
        parseList(input, 1),
    )

    private fun parseList(input: String, index: Int) = input.trimIndent().split("\n").map {
        it.split("   ")[index].toInt()
    }.toList()
}
