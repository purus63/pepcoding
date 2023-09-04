package BrowserStack;

import java.util.HashMap;
import java.util.Scanner;

public class StringTruncate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        int n= sc.nextInt();

        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            char ch= str.charAt(i);
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }
        //System.out.println(hmap);
        String ans="";
        for(int i=0;i<str.length();i++)
        {
            char ch= str.charAt(i);
            if(hmap.get(ch)!=n)
                ans+=ch;
        }
        System.out.println(ans);
    }
}
