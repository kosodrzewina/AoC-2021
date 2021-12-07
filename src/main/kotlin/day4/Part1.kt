package day4

fun doPart1(numbers: List<Int>, boards: List<Board>): Int {
    numbers.forEach {
        boards.forEach { board ->
            board.mark(it)

            if (board.hasWon) {
                return board.unmarked.sum() * it
            }
        }
    }

    return -1
}
