import scala.io.Source
import java.io.{FileReader, FileNotFoundException, IOException}

object Main 
{
    def main(args: Array[String])
    {
        println("Example 1")
        var filename = "fileopen.txt"
        for(line <- Source.fromFile(filename).getLines()){
            println(line)
        }

        println("Example 2")
        val fileLines = io.Source.fromFile("fileopen.txt").getLines.toList
        fileLines.foreach(println)


        println("Handle Exception")
        filename = "nofile.txt"

        try{
            for(line <- Source.fromFile(filename).getLines()){
                println(line)
            }
        }
        catch{
            case ex: FileNotFoundException => println("FileNotFoundException") 
            case ex: IOException => println("IOException") 
        }
    }
}
