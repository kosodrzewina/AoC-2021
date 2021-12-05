package day1

import java.io.File

fun main(args: Array<String>) {
    val input = mutableListOf<Int>()

    File(args[0]).inputStream().bufferedReader().useLines { lines ->
        lines.forEach {
            input.add(it.toInt())
        }
    }

    println("Day 1")
    println("Part 1: ${doPart1(input)}")
    println("Part 2: ${doPart2(input)}")
}
