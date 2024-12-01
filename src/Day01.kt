import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val list = input.map { line ->
            val (first, second) = line.split("""\s+""".toRegex()).map(String::toInt)
            first to second
        }

        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        for ((first, second) in list) {
            list1.add(first)
            list2.add(second)
        }

        list1.sort()
        list2.sort()

        return list1.zip(list2).fold(0) { acc, (first, second) ->
            acc + abs(first - second)
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
//    part2(input).println()
}
