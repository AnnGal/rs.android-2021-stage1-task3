package subtask2

import kotlin.math.sqrt
/*

fun main(args: Array<String>){
    val res = SquareDecomposer().decomposeNumber(50)
    //var res = arrayOf<Int>(1)
    //var res2 = res.plus( 4)
    println(res?.joinToString())
    //println(res2?.joinToString())
}

*/

class SquareDecomposer {

   fun decomposeNumber(number: Int): Array<Int>? {
        return decompose(number * number, number - 1)
    }

    private fun decompose(square: Int, number: Int): Array<Int>? {
        //println("decompose for square=$square, number=$number")
        var newSquareRootNumber: Int

        for (nextNumber in number downTo 1) {
            val nextSquare = square - nextNumber * nextNumber
            newSquareRootNumber = sqrt( nextSquare.toDouble()).toInt()

            // exit condition
            if (newSquareRootNumber >= nextNumber) {  return null }
            if (nextSquare == 0) { return arrayOf(nextNumber) }

            // recursion
            var resultArray = decompose(nextSquare, newSquareRootNumber)

            // finalize
            if (resultArray == null){
                continue
            } else {
                resultArray = resultArray.plus(nextNumber)
                return resultArray
            }
        }

        return null
    }

}
