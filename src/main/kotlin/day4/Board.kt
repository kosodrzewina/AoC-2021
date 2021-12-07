package day4

class Board(private val rows: MutableList<List<Int>> = mutableListOf()) {
    private var markedNumbers = mutableListOf<MutableList<Boolean>>()

    var hasWon = false
        private set

    val isEmpty: Boolean
        get() {
            return rows.isEmpty()
        }

    val isNotEmpty: Boolean
        get() {
            return rows.isNotEmpty()
        }

    val unmarked: List<Int>
        get() {
            val unmarked = mutableListOf<Int>()

            for (i in markedNumbers.indices) {
                for (j in markedNumbers[i].indices) {
                    if (!markedNumbers[i][j]) {
                        unmarked.add(rows[i][j])
                    }
                }
            }

            return unmarked
        }

    fun addRow(row: List<Int>) {
        if (rows.isEmpty() || row.size == rows[0].size) {
            rows.add(row)

            markedNumbers.add(mutableListOf<Boolean>().apply {
                for (i in 0 until rows[0].size) {
                    add(false)
                }
            })
        }
    }

    private fun check() {
        for (i in markedNumbers.indices) {
            var strike = 0

            for (j in markedNumbers[i].indices) {
                if (markedNumbers[i][j]) {
                    strike++
                }
            }

            if (strike == markedNumbers[0].size) {
                hasWon = true
                return
            }
        }

        for (i in 0 until markedNumbers[0].size) {
            var strike = 0

            for (j in markedNumbers.indices) {
                if (markedNumbers[j][i]) {
                    strike++
                }
            }

            if (strike == markedNumbers.size) {
                hasWon = true
                return
            }
        }
    }

    fun mark(number: Int) {
        if (hasWon) {
            return
        }

        for (i in rows.indices) {
            for (j in rows[i].indices) {
                if (rows[i][j] == number) {
                    markedNumbers[i][j] = true
                }
            }
        }

        check()
    }
}