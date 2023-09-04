package practice;



import javax.crypto.spec.PSource;
import java.io.Console;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//public class Test{ }


     class Test{

         public static void main(String[] args) {
             System.out.println(getMinDeletions("abab"));
         }

         private static int getMinDeletions(String str) {
             int arr[]= new int[26];
             for(int i=0;i<str.length();i++)
             {
                 char ch=str.charAt(i);
                 arr[ch-'a']++;
             }
             int cnt=0;
             for(int i=0;i<26;i++)
             {
                 if(arr[i]>0)
                     cnt++;
             }
             return (str.length()-cnt);
         }
     }












/*
1.
class Message{
    public void printMessage(){
        System.out.println("Hello!");
    }
}
public class Test {
    public static void main(String[] args) {
        Message msg = new Message(){
            public void printmessage(){
                System.out.println("HELLO");
            }
        } ;
        msg.printMessage();
    }
}
//Hello!

2.

class Message{
    public void printMessage(){
        System.out.println("Hello!");
    }
}
public class Test {
    public static void main(String[] args) {
        Message msg = new Message(){
            public void printmessage(){
                System.out.println("HELLO");
            }
        } ;
        msg.printMessage();
    }
}

//Hello!

3.

abstract class Animal{
    abstract void eat();
}
class Dog extends Animal{
    public void eat(){
        System.out.println("Dog eats biscuit");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("Cat eats fish");
    }
}

public class Test {
    public static void main(String[] args) {
        try{
        Animal [] animals= new Dog[2];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[0].eat();
        animals[1].eat();
    }
        catch(Exception e)
        {
            System.out.println(e);}
    }
}

//Runtime

4.

//A

5.

public class Test {
    public static void main(String[] args) {
        Stream<Integer> ns= Stream.of(10,20,30);
        ns.map(n -> n+10).peek(s-> System.out.print(s));
        ns.forEach(s-> System.out.print(s));
    }
}

//Runtime exception

6.

public class Test {
    public static void main(String[] args) {
        Path p1 = Paths.get("C:\\code\\java\\PathTest.java");
        System.out.println(p1.getName(3).toString());
    }
}

//IllegalArguementexception

7.

public class Test {
    public static void main(String[] args) {
       int[] scores1={1,2,3,4,5,6};
       int scores2[] = null;
       System.arraycopy(scores1,2,scores2,0,2);
       for(int i:scores2)
           System.out.print(i);
    }
}

// Null pointer


8.

Join

9.
null

10.

public class Test {
    public void testRefs(String str,StringBuilder sb)
    {
        str=str+sb.toString();
        sb.append(str);
        str=null;
        sb=null;
    }

    public static void main(String[] args) {

        String s ="aaa";
        StringBuilder sb = new StringBuilder("bbb");
        new Test().testRefs(s,sb);
        System.out.println("s=" +s+ " sb= "+sb);
    }
}


//s=aaa sb= bbbaaabbb

11
//555

12
//9

13.

interface Flyer{}
class Bird implements Flyer{}
class Eagle extends Bird{}
class Bat{}
public class Test {

    public static void main(String[] args) {
        Flyer f =new Eagle();
        Eagle e =new Eagle();
        Bat b= new Bat();

        if(f instanceof Flyer){
            System.out.println("A");
        }
        if(e instanceof  Bird){
            System.out.println("B");
        }
        if(b instanceof  Bird){
            System.out.println("C");
        }


    }
}

// compile time error


14.

public class Test implements Runnable{

    @Override
    public void run() {
        System.out.println("run");
        throw new RuntimeException("Problem");
    }

    public static void main(String[] args) {
        Thread t= new Thread(new Test());
        t.start();
        System.out.println("End of method");
    }
}

//
end of method
run
exception

15.

16.

17.
30 20 30

18.
andy

19.


20.

Parent

21.


22.
print tostring on map


23.
all of the above

24.

C maybe
25.


26.

compilation fails at line 5

27.
400

28
not compile


29.


30
illegal
31
sortedlist

32


333


34
4

35
1423
36

37
java lang.exception


*/