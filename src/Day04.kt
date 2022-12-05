fun main() {
    val pairs = readInput("Day04_test")
        .map { rawPair -> rawPair.split(",") }
        .map { rawPair -> Pair(toRange(rawPair[0]), toRange(rawPair[1])) };
//    part1(pairs)
    part2(pairs)
//    print(rangeOverlaps(Pair(2, 6), Pair(4, 8)));
}

fun part2(pairs: List<Pair<Pair<Int, Int>, Pair<Int, Int>>>) {
    println(pairs
        .filter { pair -> rangeOverlaps(pair.first, pair.second) }
        .count())
}

fun rangeOverlaps(first: Pair<Int, Int>, second: Pair<Int, Int>):Boolean {
    return (first.first >= second.first && first.first <= second.second) ||
            (first.second >= second.first && first.second <= second.second) ||
            (first.first < second.first && first.second > second.second) ||
            (second.first < first.first && second.second > first.second);
}

private fun part1(pairs: List<Pair<Pair<Int, Int>, Pair<Int, Int>>>) {
    println(pairs
        .filter { pair -> rangeContains(pair.first, pair.second) || rangeContains(pair.second, pair.first) }
        .count())
}

fun rangeContains(first: Pair<Int, Int>, second: Pair<Int, Int>): Boolean {
    return first.first <= second.first && first.second >= second.second;
}

fun toRange(rawRange: String): Pair<Int, Int> {
    val startAndEnd = rawRange.split("-")
    return Pair(startAndEnd[0].toInt(), startAndEnd[1].toInt());
}
