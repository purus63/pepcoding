package Design_Pattern;

class Abc implements interf{
    int n;
    String str;


    @Override
    public void method1() {
        System.out.println("aaa");
    }
}

interface interf{
    public void method1();
}

public class Test extends Abc implements interf{

    public static void main(String[] args) {
        Test t= new Test();
        t.method1();
    }

}
