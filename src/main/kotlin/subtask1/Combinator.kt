package subtask1

/*fun main(args: Array<String>){
    val res = Combinator().checkChooseFromArray(arrayOf(35, 7))
    println(res)
}*/

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val posters = array[0]
        val colors = array[1]

        for (colorNum in 1..colors) {
            if (posters <= usedCombos(colors, colorNum)) {
                return colorNum
            }
        }

        return null
    }

    private fun usedCombos(colors: Int, colorNum: Int): Int {
        return (factorial(colors) / (factorial(colorNum) * factorial(colors - colorNum))).toInt()
    }

    // factorial for number
    private fun factorial(factorialNumber: Int): Long {
        var result = 1L
        if (factorialNumber >= 2) for (i in 2..factorialNumber) result *= i
        return result
    }
}
