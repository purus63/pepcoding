package Uptox;

import java.util.*;

public class MaxArea {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();
        int len1=sc.nextInt();
        List<Integer> h= new ArrayList<>();
        for(int i=0;i<len1;i++)
            h.add(sc.nextInt());
        int len2=sc.nextInt();
        List<Integer> v= new ArrayList<>();
        for(int i=0;i<len2;i++)
            v.add(sc.nextInt());
        System.out.println(prison(n,m,h,v));

    }
    static int helper1(List<Integer> list)
    {
        int n=list.size();
        HashSet<Integer> S = new HashSet<Integer>();
        for (int i = 0; i < n; i++)
            S.add(list.get(i));
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            if(S.contains(list.get(i)))
            {
                int j = list.get(i);
                while (S.contains(j))
                    j++;
                ans = Math.max(ans, j - list.get(i));
            }
        }
        return ans+1;
    }
    private static long prison(int n, int m, List<Integer> h, List<Integer> v) {

        Collections.sort(h);
        Collections.sort(v);
        int max1=2;
        int max2=2;
        max1=Math.max(max1,helper1(h));
        max2=Math.max(max2,helper1(v));
        return max1*max2;
    }
}
