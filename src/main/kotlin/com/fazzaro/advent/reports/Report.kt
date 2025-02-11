package com.fazzaro.advent.reports

class Report(input: String) {
    val levels: List<Int> = parse(input)

    private fun parse(input: String) = input.split(" ").map {
        it.toInt()
    }.toList()
}

