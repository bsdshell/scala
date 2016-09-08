object Main {
    def main(args: Array[String]) {
        println("Hello")
        System.out.println("dog");
        f("dog")
    }
    def f(x:String): Int= {
        println("my f")
        3
    }
}
