fun main() {

    val priorities = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    part1(readInput("Day03_test"), priorities)
    part2(readInput("Day03_test"), priorities)
//    part2(readInput("Day03_example"), priorities)
}

fun part2(readInput: List<String>, priorities: String) {
    val priorities = readInput.chunked(3)
        .map { group -> commonInGroup(group) }
        .map { commonChar -> toPriority(priorities, commonChar) }
    println(priorities.sum());
}

fun commonInGroup(group: List<String>): Char {
    return group.first().chars()
        .filter { char -> group.get(1).contains(char.toChar(), false) && group.get(2).contains(char.toChar(), false) }
        .findFirst()
        .asInt
        .toChar();
}

private fun part1(testInput: List<String>, priorities: String) {
    val commonChars = testInput.map { rawGame -> rawGame.chunked(rawGame.length / 2) }
        .map { chunked -> Pair(chunked.first(), chunked.last()) }
        .map { compartments -> compartments.first.chars().filter { char -> compartments.second.contains(char.toChar(), false) }.findFirst() }
        .filter { commonChar -> commonChar.isPresent }
        .map { commonChar -> commonChar.asInt }
        .map { commonChar -> commonChar.toChar() };
    val priorities = commonChars.map { commonChar -> toPriority(priorities, commonChar) }
    println(priorities.sum());
}

private fun toPriority(priorities: String, commonChar: Char) = priorities.indexOf(commonChar, 0, false)
