package Recursion;

import java.io.*;
import java.util.*;

public class Combination_I {

    static void combination( char[] boxes,int idx,int ci,int ti)
    {

        if(ci>ti)
        {
            for(char ch:boxes)
                System.out.print(ch);
            System.out.println();
            return;
        }

        for(int i=idx;i<boxes.length;i++)
        {
            if(boxes[i]=='-')
            {
                boxes[i]='i';
                combination(boxes,i+1,ci+1,ti);
                boxes[i]='-';
            }
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        char[] ch= new char[nboxes];
        Arrays.fill(ch,'-');
        combination(ch,0,1,ritems);


    }

}