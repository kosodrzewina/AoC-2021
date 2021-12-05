package day1

fun doPart2(measurements: List<Int>): Int {
    var increaseCount = 0
    val slidingWindow = ArrayDeque<Int>()

    measurements.forEach {
        if (slidingWindow.size < 3) {
            slidingWindow.add(it)
        } else {
            if (slidingWindow.subList(1, 3).sum() + it > slidingWindow.sum()) {
                increaseCount++
            }

            slidingWindow.removeFirst()
            slidingWindow.add(it)
        }
    }

    return increaseCount
}
