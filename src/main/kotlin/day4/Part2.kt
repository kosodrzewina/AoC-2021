package day4

fun doPart2(numbers: List<Int>, boards: MutableList<Board>): Int {
    var disappointingBoard: Board? = null
    var lastCalled: Int? = null

    numbers.forEach {
        val winnerBoards = mutableListOf<Board>()

        for (i in boards.indices) {
            boards[i].mark(it)

            if (boards[i].hasWon) {
                winnerBoards.add(boards[i])
                disappointingBoard = boards[i]
                lastCalled = it
            }
        }

        winnerBoards.forEach { board ->
            boards.remove(board)
        }
    }

    disappointingBoard?.let {
        lastCalled?.let { lastCalled ->
            val lmao = it.unmarked.sum()
            return it.unmarked.sum() * lastCalled
        }
    }

    return -1
}
