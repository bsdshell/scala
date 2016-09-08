class MyPoint(xc: Int, yc: Int) {
val x:
    Int = xc
      val y:
          Int = yc
                def move(dx: Int, dy: Int): MyPoint = new MyPoint(xc, yc)

        override def toString(): String = "(" + x + "," + y + ")"
    }

    class MySubPoint(xc: Int, yc: Int, zc: Int) extends MyPoint(xc, yc) {
var xcc:
    Int = xc + zc;
var ycc:
    Int = yc + zc;

    override def move(dx: Int, dy: Int): MySubPoint = {
        return new MySubPoint(xcc, ycc, zc)
    }
    override def toString(): String = "[" + xcc + "," + ycc + "]"
    }

    object Main {
    def main(args: Array[String]) {
        println("Hello");
        val pt = new MyPoint(3, 4);
        println(pt);
        pt.move(10, 10);
        println(pt);

        val subpt = new MySubPoint(1, 2, 3);
        println(subpt);
        subpt.move(5, 5);
        println(subpt);

var myArray:
        Array[Int] = new Array[Int](5)
        myArray(0) = 9;
        myArray(1) = 1;
        myArray(2) = 7;
        myArray(3) = 4;
        myArray(4) = 2;

        sort(myArray)
        for(c <- 0 until myArray.length) {
            println("Array[" + c + "]=" + myArray(c))
        }
        println(sum(x=>2*x)(10, 20))
    }
    //This is called currying function
    def sum(f: Int=>Int)(a:Int, b:Int): Int = {
        if(a > b) 0 else f(a) + sum(f)(a+1, b)
    }

    def sort(xs: Array[Int]) {
        def swap(i: Int, j: Int) {
            val t = xs(i);
            xs(i) = xs(j);
            xs(j) = t
        }
        def printArray(xs: Array[Int]) {
            for(c <- 0 until xs.length)
                println("Array[" + c + "]=" + xs(c))
            }
        def partition(l:Int, r:Int) : Int = {
            val pivot = xs(r)
            var big = 0
            var curr = 0
            while(curr < xs.length) {
                if(xs(curr) < pivot) {
                    swap(big, curr)
                    big += 1
                }
                curr += 1
            }
            swap(big, r)
            return big
        }
        def Quicksort(l:Int, r:Int) {
            if(l < r) {
                var pivotIndex = partition(l, r)
                                 if(l < pivotIndex) Quicksort(l, pivotIndex-1)
                                     if(pivotIndex < r) Quicksort(pivotIndex+1, r)
                    }
        }
        Quicksort(0, xs.length-1)
    }
}
