import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (list1, list2) = input
                .map { line ->
                    val (first, second) = line.split("""\s+""".toRegex()).map(String::toInt)
                    first to second
                }
                .unzip()

        return list1.sorted().zip(list2.sorted()).fold(0) { acc, (first, second) ->
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
