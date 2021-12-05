package day2

fun doPart1(commands: List<String>): Int {
    var horizontalPosition = 0
    var depth = 0

    commands.forEach {
        val command = it.split(" ")
        val value = command[1].toInt()

        when (command[0]) {
            "forward" -> horizontalPosition += value
            "down" -> depth += value
            "up" -> depth -= value
        }
    }

    return horizontalPosition * depth
}
