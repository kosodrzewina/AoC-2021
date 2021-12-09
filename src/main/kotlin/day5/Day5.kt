package day5

import java.io.File

fun main(args: Array<String>) {
    val pairs = mutableListOf<Pair<Point, Point>>()

    File(args[0]).inputStream().bufferedReader().useLines { lines ->
        lines.forEach {
            val splitted = it.split(" -> ")
            val firstPart = splitted[0].split(",")
            val secondPart = splitted[1].split(",")

            pairs.add(
                Pair(
                    Point(Integer.parseInt(firstPart[0]), Integer.parseInt(firstPart[1])),
                    Point(Integer.parseInt(secondPart[0]), Integer.parseInt(secondPart[1]))
                )
            )
        }
    }

    println("Day 5")
    println("Part 1: ${doPart1(pairs)}")
    println("Part 2: ${doPart2(pairs)}")
}
