package subtask3

//import java.lang.StringBuilder

/*
fun main(args: Array<String>){
    val res = TelephoneFinder().findAllNumbersFromGivenNumber("8675309")
    println(res?.joinToString() + "  size = ${res?.size}")
    // 2 4  6  8
}*/

class TelephoneFinder {

    private val nearestNumbers: Map<Char, Array<Char>> = mapOf(
        '0' to arrayOf('8'),
        '1' to arrayOf('2','4'),
        '2' to arrayOf('1','3','5'),
        '3' to arrayOf('2','6'),
        '4' to arrayOf('1','5','7'),
        '5' to arrayOf('2','4','6', '8'),
        '6' to arrayOf('3','5','9'),
        '7' to arrayOf('4','8'),
        '8' to arrayOf('5','7','9','0'),
        '9' to arrayOf('6','8')
    )

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.isEmpty() || number.toInt() < 0) return null

        val result = mutableListOf<String>()

        number.forEachIndexed { index, char ->

            nearestNumbers[char]?.forEach { charNearest: Char ->
                result.add(number.replace(number.elementAt(index), charNearest))
            }

        }

        return result.toTypedArray()
    }
}
