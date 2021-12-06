package day3

import java.io.File

fun main(args: Array<String>) {
    val input = mutableListOf<String>()

    File(args[0]).inputStream().bufferedReader().useLines { lines ->
        lines.forEach {
            input.add(it)
        }
    }

    println("Day 3")
    println("Part 1: ${doPart1(input)}")
    println("Part 2: ${doPart2(input)}")
}
