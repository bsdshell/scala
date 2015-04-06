import scala.annotation.tailrec

class factorial  
{
    @tailrec
    final def tail_calculate(x: Int, y: Int=1): Int = {
        if(x == 1) y else tail_calculate(x-1, x*y)
    }

    def head_calculate(x: Int, y: Int=1): Int = {
        if(x == 1) y else head_calculate(x-1, x*y)
    }
}

object Main 
{
    def main(args: Array[String])
    {
        val fac = new factorial()
        println(fac.tail_calculate(10, 10))
        println(fac.head_calculate(10, 10))
    }
}
