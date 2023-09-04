package practice;

import java.io.*;
import java.util.*;



class ABC{
    public void walk()
    {
        System.out.println("Parent Walk method");
    }
    public void run()
    {
        this.walk();
        System.out.println("Parent Run method");
    }
}
class Solution extends ABC{
    public void walk()
    {
        super.walk();
        System.out.println("Child Walk method");
    }
    public void run()
    {
        super.run();
        System.out.println("Child Run method");
    }
    public static void main( String args[]) {
        Solution obj = new Solution();
        obj.run();
    }
}
