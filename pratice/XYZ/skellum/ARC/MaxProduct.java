package XYZ.skellum.ARC;

import java.util.ArrayList;
import java.util.List;

public class MaxProduct {
    public static void main(String[] args) {

        int arr[]={3,7};
        System.out.println(maximumProduct(arr,2));
    }

    private static int maximumProduct(int[] arr, int n) {

        List<List<Integer>> list = subsets(arr);
        long res=1;

        for(List<Integer> al :list)
        {
            long max_val = 1;
            for(int a:al)
            {
                if(max_val<a)
                    max_val=a;
            }
            res=(res*max_val)%1000000007;
        }
        return (int)res;
    }
    public static  List<List<Integer>> subsets(int[] nums) {
            int n=nums.length;
            int size =(int)Math.pow(2,n);
            List<List<Integer>> list = new ArrayList<>();


            for(int i=0;i<size;i++)
            {
                List<Integer> al= new ArrayList<>();
                int k=i;
                for(int j=n-1;j>=0 && k>0;j--)
                {
                    int idx=k%2;
                    k=k/2;
                    if(idx==0)
                        continue;
                    else
                        al.add(nums[j]);
                }
                list.add(al);
            }
            return list;
        }


}
