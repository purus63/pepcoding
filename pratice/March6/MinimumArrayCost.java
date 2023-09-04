package March6;

import java.util.Arrays;

public class MinimumArrayCost {
    public static void main(String[] args) {
        int arr[]={4,7,1,4};
        int diff[]=findmaxdiff(arr);
        int ans=calculate(arr);
        int mid=(diff[1]+diff[2])/2;
        System.out.println((2*diff[1]*diff[2]+ans)+2*(mid*mid)-2*mid*diff[1]-2*mid*diff[2]);
    }
    private static int calculate(int[] arr) {
        int ans=0;
        for(int i=1;i<arr.length;i++)
            ans+=Math.pow((arr[i]-arr[i-1]),2);
        return ans;
    }
    private static int[] findmaxdiff(int[] arr) {
        int diff=0;
        int a=arr[0];
        int b=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(Math.abs(arr[i]-arr[i-1])>diff) {
                diff = Math.abs(arr[i] - arr[i - 1]);
                a=arr[i-1];
                b=arr[i];
            }
        }
        return new int[]{diff,a,b};
    }
}
