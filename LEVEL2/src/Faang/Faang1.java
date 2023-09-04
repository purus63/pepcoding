package Faang;

import java.io.*;
import java.util.*;

class Faang1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> hmap= new HashMap<>();
        for(int a:arr)
            hmap.put(a,hmap.getOrDefault(a,0)+1);

        for(int key:hmap.keySet())
        {
            if(hmap.get(key)>1)
            {
                al.add(key);
            }
        }
        return al;
    }
}
