package day4

import java.io.File

fun main(args: Array<String>) {
    val numbers = mutableListOf<Int>()
    val boards = mutableListOf<Board>()

    File(args[0]).inputStream().bufferedReader().useLines { lines ->
        var isNumbers = true
        var board = Board()

        lines.forEach { line ->
            if (isNumbers) {
                line.split(",").forEach {
                    numbers.add(Integer.parseInt(it))
                }

                isNumbers = false
            } else {
                if (line == "" && board.isNotEmpty) {
                    boards.add(board)
                    board = Board()
                } else if (line != "") {
                    val row = mutableListOf<Int>()

                    line.trim().split("\\s+".toRegex()).forEach {
                        row.add(Integer.parseInt(it))
                    }

                    board.addRow(row)
                }
            }
        }

        if (board.isNotEmpty) {
            boards.add(board)
        }
    }

    println("Day 4")
    println("Part 1: ${doPart1(numbers, boards)}")
    println("Part 2: ${doPart2(numbers, boards)}")
}
