package day5

class Point(var x: Int, var y: Int) {
    fun switchValues() {
        val temp = x

        x = y
        y = temp
    }

    fun copy() = Point(x, y)
}