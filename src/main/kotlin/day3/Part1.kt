package day3

fun doPart1(numbersBin: List<String>): Int {
    val zeros = IntArray(numbersBin[0].length)
    val ones = IntArray(numbersBin[0].length)

    numbersBin.forEach {
        for (i in it.indices) {
            if (it[i] == '0') {
                zeros[i]++
            } else {
                ones[i]++
            }
        }
    }

    var gammaRateBin = ""
    var epsilonRateBin = ""

    for (i in zeros.indices) {
        if (zeros[i] > ones[i]) {
            gammaRateBin += '1'
            epsilonRateBin += '0'
        } else {
            gammaRateBin += '0'
            epsilonRateBin += '1'
        }
    }

    return Integer.parseInt(gammaRateBin, 2) * Integer.parseInt(epsilonRateBin, 2)
}
