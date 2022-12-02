fun main() {
    val testInput = readInput("Day01_test")
    val calByElf = testInput.fold(mutableListOf(mutableListOf<Int>())) {
        acc, cal ->  if (cal.isBlank()) acc.add(mutableListOf()) else acc.last().add(cal.toInt())
        acc
    }
    println(calByElf.map { cals -> cals.sum() }.max());
    println(calByElf.map { cals -> cals.sum() }.sortedDescending().take(3).sum())
}
