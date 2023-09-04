package XYZ.skellum;

import java.util.ArrayList;
import java.util.List;

public class test3 {

    public static void main(String[] args) {

       helper("ganga","");
    }
    //abc
    /*
        abc
        acb
        bac
        bca
        cab
        cba
    */
    //ab


    private static void helper(String str,String res) {

            if(str.length()==0)
                System.out.println(res);

            for(int i=0;i<str.length();i++)
            {
                char ch= str.charAt(i);
                String left=str.substring(0,i);
                String right=str.substring(i+1);
                helper(left+right,res+ch);
            }
    }



}
