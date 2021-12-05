package day2

fun doPart2(commands: List<String>): Int {
    var horizontalPosition = 0
    var depth = 0
    var aim = 0

    commands.forEach {
        val command = it.split(" ")
        val value = command[1].toInt()

        when (command[0]) {
            "down" -> aim += value
            "up" -> aim -= value
            "forward" -> {
                horizontalPosition += value
                depth += aim * value
            }
        }
    }

    return horizontalPosition * depth
}