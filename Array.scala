import scala.io.Source
import java.io.{FileReader, FileNotFoundException, IOException}

object Main {
    def main(args: Array[String]) {
var myArray:
        Array[String] = new Array[String](10)
        myArray(0) = "dog"
        myArray(1) = "cat"
        myArray(2) = "cow"
        myArray(3) = "pig"
        myArray(4) = "chicken"
        myArray(5) = "duck"
        myArray(6) = "bird"
        myArray(7) = "wolf"
        myArray(8) = "coyote"
        myArray(9) = "zebra"

        for(i <- 0 until myArray.length) {
            println("Array[" + i + "]=" + myArray(i))
        }

        //Two dimension array
        var array2D = Array(
                          Array(1, 2, 3),
                          Array(4, 5, 6),
                          Array(7, 8, 9)
                      )

        for(c <- 0 until array2D.length) {
            for(r <- 0 until array2D(c).length) {
                println("Array[" + c + "][" + r + "]=" + array2D(c)(r))
            }
        }
    }
}
