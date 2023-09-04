package practice;

import java.util.Scanner;

public class InversionCnt {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for(long i = 0; i < n; i++)
                arr[(int)i] = sc.nextLong();

            System.out.println(inversionCount(arr, n));

        }
    }
    static long cnt=0;
    static long inversionCount(long arr[], long n)
    {
        cnt=0;
        mergesort(arr,0,n-1);
        return cnt;
    }


    static void mergesort(long arr[],long lo,long hi)
    {

        if(lo==hi)
            return;
        long mid= lo+(hi-lo)/2;
        mergesort(arr,lo,mid);
        mergesort(arr,mid+1,hi);
        merge(arr,lo,mid,hi);

    }

    static void merge(long arr[],long lo,long mid,long hi)
    {

        long l1=mid-lo+1;
        long r1=hi-mid;

        long arr1[] = new long[(int)l1];
        long arr2[] = new long[(int)r1];
        for(int i=0;i<l1;i++){arr1[i]=arr[(int)(lo+i)];}
        for(int i=0;i<r1;i++){arr2[i]=arr[(int)(mid+1+i)];}

        int i=0,j=0,k=0;

        while(i<l1 && j<r1)
        {
            if(arr1[i]<=arr2[j])
            {
                arr[k++]=arr1[i++];
            }
            else
            {
                arr[k++]=arr2[j++];
                cnt+=l1-i;
            }
        }

        while(i<l1)
            arr[k++]=arr1[i++];

        while(j<r1)
            arr[k++]=arr2[j++];

    }
}
