package XYZ.skellum.ARC;

import java.util.*;

public class TroopsCats {
    public static void main(String[] args) {

        int n=5;
        int arr[]={1,2,3,4,2};
        int ht=5;
        int u=2,v=3;

        System.out.println(getminseconds(n,arr,ht,u,v));

    }

    private static int getminseconds(int n, int[] arr, int ht, int u, int v) {

        Arrays.sort(arr);
        int rt=arr.length-1;
        int lt=0;
        int res=0;//1123

        int sum=0;
        int cnt=0;
        while(lt<=rt)
        {
            sum+=arr[lt++];
            cnt++;
            if(sum>ht)
            {
                if(cnt<=2)
                    res+=u;
                else
                    res+=v;

                lt--;
                sum=0;
                cnt=0;
            }
        }
        if(cnt<=2)
            res+=u;
        else
            res+=v;
        return res;
    }
}
