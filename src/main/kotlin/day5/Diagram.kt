package day5

class Diagram(height: Int, width: Int) {
    private val rows = mutableListOf<MutableList<Int>>()

    init {
        for (i in 0 until height) {
            rows.add(mutableListOf())

            for (j in 0 until width) {
                rows[i].add(0)
            }
        }
    }

    companion object {
        fun getLinePointsHorizontalOrVertical(point1: Point, point2: Point): List<Point> {
            var p1 = point1.copy()
            var p2 = point2.copy()
            val points = mutableListOf<Point>()

            var dx = p2.x - p1.x
            var flipped = false

            if (dx == 0) {
                p1.switchValues()
                p2.switchValues()

                dx = p2.x - p1.x
                flipped = true
            }

            if (dx < 0) {
                val switchedPoints = switchPoints(p1, p2)

                p1 = switchedPoints.first
                p2 = switchedPoints.second
            }

            for (x in p1.x..p2.x) {
                if (flipped) {
                    points.add(Point(p1.y, x))
                } else {
                    points.add(Point(x, p1.y))
                }
            }

            return points
        }

        fun getLinePointsDiagonal(point1: Point, point2: Point): List<Point> {
            var p1 = point1.copy()
            var p2 = point2.copy()
            val points = mutableListOf<Point>()

            if (p1.y > p2.y) {
                val switchedPoints = switchPoints(p1, p2)

                p1 = switchedPoints.first
                p2 = switchedPoints.second
            }

            var x = p1.x
            var y = p1.y

            points.add(Point(x, y))
            while (x != p2.x || y != p2.y) {
                if (p1.x < p2.x) {
                    x++
                    y++
                } else {
                    x--
                    y++
                }

                points.add(Point(x, y))
            }

            return points
        }

        fun switchPoints(point1: Point, point2: Point): Pair<Point, Point> {
            var p1 = point1.copy()
            var p2 = point2.copy()

            val temp = p1.copy()

            p1 = p2.copy()
            p2 = temp

            return Pair(p1, p2)
        }
    }

    fun markLine(point1: Point, point2: Point, markDiagonal: Boolean) {
        var points: List<Point>? = null

        if (point1.x - point2.x == 0 || point1.y - point2.y == 0) {
            points = getLinePointsHorizontalOrVertical(point1, point2)
        } else if (markDiagonal) {
            points = getLinePointsDiagonal(point1, point2)
        }

        points?.let {
            it.forEach { point ->
                rows[point.y][point.x]++
            }
        }
    }

    fun countOverlaps(): Int {
        var overlaps = 0

        rows.forEach {
            it.forEach { number ->
                if (number > 1) {
                    overlaps++
                }
            }
        }

        return overlaps
    }
}