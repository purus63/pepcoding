package zeta;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        int[] arr  = {1,4,1};

        int narr[] = new int[2*arr.length-1];
        int i=0;
        for(i=0;i<arr.length;i++)
            narr[i]=arr[i];
        for(;i<narr.length;i++)
            narr[i]=arr[i-arr.length];

        int nge[] = ngre(arr);

    }

    private static int[] ngre(int[] arr) {

        Stack<Integer> st= new Stack<>();

    }
}
