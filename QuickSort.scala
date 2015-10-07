import language.postfixOps

object Main 
{
    def main(args: Array[String])
    {
        test1()
        test2()
        test3()
        test4()
    }

    def test1() {
        println("test1");
    var myArray: Array[Int] = new Array[Int](5)
        myArray(0) = 9;
        myArray(1) = 1;
        myArray(2) = 7;
        myArray(3) = 4;
        myArray(4) = 2;

        sort(myArray)
        for(c <- 0 until myArray.length)
            println("Array[" + c + "]=" + myArray(c))
        println();
    }

    def test2(){
        println("test2");
    var myArray: Array[Int] = new Array[Int](1)
        myArray(0) = 9;

        sort(myArray)
        for(c <- 0 until myArray.length)
            println("Array[" + c + "]=" + myArray(c))
        println();
    }

    def test3() {
        println("test3");
    var myArray: Array[Int] = new Array[Int](5)
        myArray(0) = 1;
        myArray(1) = 2;
        myArray(2) = 3;
        myArray(3) = 4;
        myArray(4) = 5;

        sort(myArray)
        for(c <- 0 until myArray.length)
            println("Array[" + c + "]=" + myArray(c))
        println();
    }

    def test4() {
        println("test4");
        var myArray: Array[Int] = new Array[Int](5)
        myArray(0) = 1;
        myArray(1) = 2;
        myArray(2) = 3;
        myArray(3) = 4;
        myArray(4) = 5;

        sortfun(myArray)
        for(c <- 0 until myArray.length)
            println("Array[" + c + "]=" + myArray(c))
        println();

    }
    def sort(xs: Array[Int])
    {
        def partition(l:Int, r:Int) : Int = 
        {
            def swap(i: Int, j: Int) {
                val t = xs(i); xs(i) = xs(j); xs(j) = t
            }

            val pivot = xs(r)
            var big = 0
            var curr = 0
            while(curr < xs.length)
            {
                if(xs(curr) < pivot)
                {
                    swap(big, curr)
                    big += 1
                }
                curr += 1
            }
            swap(big, r)

            return big
        }
        def Quicksort(l:Int, r:Int)
        {
            if(l < r)
            {
                var pivotIndex = partition(l, r)
                if(l < pivotIndex) Quicksort(l, pivotIndex-1)
                if(pivotIndex < r) Quicksort(pivotIndex+1, r)
            }
        }
        Quicksort(0, xs.length-1)
    }
    
    def sortfun(xs: Array[Int]): Array[Int] = {
        if(xs.length <= 1) xs
        else{
            val pivot = xs(xs.length/2)
            Array.concat(
                sortfun(xs filter (pivot < )),
                sortfun(xs filter (pivot == )),
                sortfun(xs filter (pivot > ))
            )
        }
    }
}
