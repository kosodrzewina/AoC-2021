package day3

fun doPart2(numbersBin: MutableList<String>): Int {
    val numbersCo2Bin = numbersBin.toMutableList()

    for (i in numbersBin[0].indices) {
        if (numbersBin.size > 1) {
            var zeros = 0
            var ones = 0

            numbersBin.forEach {
                if (it[i] == '0') {
                    zeros++
                } else {
                    ones++
                }
            }

            if (ones >= zeros) {
                numbersBin.removeIf { num -> num[i] == '0' }
            } else {
                numbersBin.removeIf { num -> num[i] == '1' }
            }
        }

        if (numbersCo2Bin.size > 1) {
            var zeroes = 0
            var ones = 0

            numbersCo2Bin.forEach {
                if (it[i] == '0') {
                    zeroes++
                } else {
                    ones++
                }
            }

            if (zeroes <= ones) {
                numbersCo2Bin.removeIf { num -> num[i] == '1' }
            } else {
                numbersCo2Bin.removeIf { num -> num[i] == '0' }
            }
        }
    }

    return Integer.parseInt(numbersBin[0], 2) * Integer.parseInt(numbersCo2Bin[0], 2)
}