package day5

fun doPart1(points: List<Pair<Point, Point>>): Int {
    val diagram = Diagram(1000, 1000)

    points.forEach {
        diagram.markLine(it.first, it.second, false)
    }

    return diagram.countOverlaps()
}
