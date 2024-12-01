import kotlin.math.abs

fun main() {
    fun prepareInput(input: List<String>): Pair<List<Int>, List<Int>> = input
            .map { line ->
                val (first, second) = line.split("""\s+""".toRegex()).map(String::toInt)
                first to second
            }
            .unzip()

    fun part1(input: Pair<List<Int>, List<Int>>): Int {
        val (list1, list2) = input

        return list1.sorted().zip(list2.sorted()).fold(0) { acc, (first, second) ->
            acc + abs(first - second)
        }
    }

    fun part2(input: Pair<List<Int>, List<Int>>): Int {
        val (list1, list2) = input

        val lookup = list2.groupBy { it }
                .map { (key, entry) -> key to entry.size }
                .toMap()

        return list1.fold(0) { acc, i ->
            acc + i * lookup.getOrDefault(i, 0)
        }
    }

    val testInput = prepareInput(readInput("Day01_test"))
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = prepareInput(readInput("Day01"))
    val resultPart1 = part1(input)
    check(resultPart1 == 2815556)
    resultPart1.println()

    val resultPart2 = part2(input)
    check(resultPart2 == 23927637)
    resultPart2.println()
}
