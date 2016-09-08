import language.postfixOps

object Main {
    def main(args: Array[String]) {
        test1
        test2
        test3
    }
   //[file=MergeSortList.html title="merge sorted lists"
   def merge(xs1: Array[Int], xs2:Array[Int]): Array[Int] = {
        val len1 = xs1.length 
        val len2 = xs2.length 
        
        var i = 0
        var j = 0
        var k = 0
        var xs3: Array[Int] = new Array[Int](len1+len2) 
        while(i < len1 || j < len2) {
            if(i >= len1){ 
                xs3(k) = xs2(j) 
                j += 1
            }else if(j >= len2){
                xs3(k) = xs1(i) 
                i += 1 
            }else{
                if(xs1(i) < xs2(j)){
                    xs3(k) = xs1(i)
                    i += 1
                }else{
                    xs3(k) = xs2(j)
                    j += 1
                }
            }
            k += 1
        }
        return xs3
    }
    //]
    def test1{
        println("test1")
        var xs1 = Array(1, 4, 7)
        var xs2 = Array(2, 3, 8)
        var list = merge(xs1, xs2)
        for(c <- 0 until list.length)
            println("list[" + c + "]=" + list(c))
    }
    def test2{
        println("test2")
        var xs1 = Array(1)
        var xs2 = Array(2)
        var list = merge(xs1, xs2)
        for(c <- 0 until list.length)
            println("list[" + c + "]=" + list(c))
    }
    def test3{
        println("test3")
        var xs1 = Array(1, 4, 20)
        var xs2 = Array(2, 3, 100)
        var list = merge(xs1, xs2)
        for(c <- 0 until list.length)
            println("list[" + c + "]=" + list(c))
    }
}
