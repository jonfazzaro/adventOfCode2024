class ReportParser(input: String) {

    val reports: List<Report> = parse(input)

    private fun parse(input: String) = input.trimIndent().split("\n").map {
        Report(it)
    }.toList()
}

