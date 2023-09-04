package practice;

 class Parent {
     public void run() {
         walk();
         System.out.println("Parent run");
     }

     public void walk() {
         System.out.println("Parent walk");
     }
 }

class Child extends Parent {
    @Override
    public void run() {
        super.run();
        System.out.println("child run");
    }
    @Override
    public void walk() {
        super.walk();
        System.out.println("child walk");
    }
}


    public class FirstJava {
        public static void main(String[] a) {
            Parent c = new Child();
            c.run();
        }
    }