/*
trail Similary
{
    def isSimilar(x: Any): Boolean
    def isNotSimilar(x: Any): Boolean = !isSimilar(x)
}

class Point(xc: Int, yc: Int) extends Similary
{
    var x: Int=xc;
    var y: Int=yc;
    def isSimilar(obj: Any)
    {
        obj.isInstanceOf[Point] && 
        obj.asInstanceOf[Point].x == x
    }
}
*/

class MyPoint(xc: Int, yc: Int)
{
    val x: Int = xc
    val y: Int = yc
    def move(dx: Int, dy: Int): MyPoint = new MyPoint(xc, yc)

    override def toString(): String = "(" + x + "," + y + ")"
}

class MySubPoint(xc: Int, yc: Int, zc: Int) extends MyPoint(xc, yc)
{
    var xcc: Int = xc + zc;
    var ycc: Int = yc + zc;

    override def move(dx: Int, dy: Int): MySubPoint = 
    {
        return new MySubPoint(xcc, ycc, zc)
    }
    override def toString(): String = "[" + xcc + "," + ycc + "]"
}


object Main 
{
    def main(args: Array[String])
    {
        println("Hello");
        val pt = new MyPoint(3, 4);
        println(pt);
        pt.move(10, 10);
        println(pt);

        val subpt = new MySubPoint(1, 2, 3);
        println(subpt);
        subpt.move(5, 5);
        println(subpt);
    }
}
