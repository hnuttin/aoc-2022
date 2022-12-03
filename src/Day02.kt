enum class RPS(val score: Int) {
    A(1), X(1),
    B(2), Y(2),
    C(3), Z(3);

    fun fight(rps: RPS): Int {
        return when (this) {
            A -> if (rps == X) 3 else if (rps == Y) 6 else 0
            B -> if (rps == X) 0 else if (rps == Y) 3 else 6
            C -> if (rps == X) 6 else if (rps == Y) 0 else 3
            else -> throw IllegalArgumentException()
        }
    }

    fun perform(rps: RPS): Int {
        return when (this) {
            A -> if (rps == X) C.score else if (rps == Y) 3 + A.score else 6 + B.score
            B -> if (rps == X) A.score else if (rps == Y) 3 + B.score else 6 + C.score
            C -> if (rps == X) B.score else if (rps == Y) 3 + C.score else 6 + A.score
            else -> throw IllegalArgumentException()
        }
    }
}

fun main() {
    val testInput = readInput("Day02_test")
    val games = testInput.map { rawGame -> rawGame.split(" ") }
        .map { gameChoices -> Pair(RPS.valueOf(gameChoices[0]), RPS.valueOf(gameChoices[1])) };
    println(games.map { game -> game.first.fight(game.second).plus(game.second.score) }.sum());
    println(games.map { game -> game.first.perform(game.second) }.sum());
}
