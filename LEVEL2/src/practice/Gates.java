package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Gates {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int h=0;
        int t= sc.nextInt();
        ArrayList<Integer> res= new ArrayList<>();
        while(t-->0)
        {
            h = sc.nextInt();
            int n= (int)Math.pow(2,h-1);
            ArrayList<Integer> arr= new ArrayList<>();
            ArrayList<ArrayList<String>> list= new ArrayList<>();
            for(int i=0;i<n;i++) {
                arr.add(sc.nextInt());
            }
            for(int i=0;i<h-1;i++)
                list.add(new ArrayList<>());
            sc.nextLine();
            for(int i=0;i<h-1;i++)
            {
                    String str=sc.nextLine();
                    String[] input=str.split(" ");
                    for(String s:input)
                        list.get(i).add(s);
            }


            ArrayList<Integer> al =new ArrayList<>();
            for(ArrayList<String> ll :list)
            {
                for(int i=0;i<ll.size();i++)
                {
                    al.add(eval(arr.get(2*i),arr.get(2*i+1),ll.get(i)));
                }
                arr=al;
                al=new ArrayList<>();
            }
            res.add(arr.get(0));
        }
        System.out.println(res);
    }
    private static int eval(int a, int b, String op) {

        if(op.equals("and"))
            return a&b;
        if(op.equals("or"))
            return a|b;
        if(op.equals("xor"))
            return a^b;
        if(op.equals("nand"))
            return (a&b)==1?0:1;
        if(op.equals("nor"))
            return (a|b)==1?0:1;
        if(op.equals("xnor"))
            return (a^b)==1?0:1;
        return 0;
    }

}
/*
3
2
1 0
or
4
1 1 0 1 1 0 0 0
xor nand or and
or nor
xnor
3
1 1 1 1
and and
and*/
