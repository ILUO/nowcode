package iluo.TestFOO;

public class Foo {
    public int foo1(int n){
        if(n == 1){
            return 1;
        }else{
            return n * foo1(n-1);
        }
    }

    public static  void main(String [] args){
        Foo foo = new Foo();
        System.out.println(foo.foo1(4));
    }

}
