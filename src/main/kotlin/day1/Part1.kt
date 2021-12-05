package day1

fun doPart1(measurements: List<Int>): Int {
    var increaseCount = 0
    var previousMeasurement: Int? = null

    measurements.forEach {
        previousMeasurement?.let { previousMeasurement ->
            if (it > previousMeasurement) increaseCount++
        }

        previousMeasurement = it
    }

    return increaseCount
}
