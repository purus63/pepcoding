package XYZ.skellum;

import java.util.Scanner;

public class ChargeBee {
    public static void main(String[] args) {

        int n;long k;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();k=sc.nextLong();

        int arr[]= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int ans[]=solve(n,k,arr);

        for(int a:ans)
            System.out.print(a+"  ");
    }

    static int[] solve(int n,long k,int[] arr)
    {
        int prime[]= new int[100001];
        prime[0]=2;prime[1]=2;
        for(int i=2;i*i<=100000;i++)
        {
            if(prime[i]==0) {
                for (int j = i * i; j <= 100000; j += i) {
                    prime[j] = 1;
                }
            }
        }
        prime[100000]=100003;
        int last=100003;
        for(int i=99999;i>1;i--)
        {
            if(prime[i]==1)
                prime[i]=last;
            else {
                prime[i] = i;
                last=i;
            }
        }

        for(int i=0;i<n;i++)
        {
            if(prime[arr[i]]==arr[i])
            {
                if(k%2==0)
                    arr[i]=prime[arr[i]];
                else
                    arr[i]=arr[i]-1;
            }
            else
            {
                if(arr[i]+k>prime[arr[i]])
                {
                    if((arr[i]+k-prime[arr[i]])%2==0)
                    {arr[i]=prime[arr[i]];}
                    else
                    {arr[i]=prime[arr[i]]-1;}
                }
                else
                {
                    arr[i]=arr[i]+(int)k;
                }
            }
        }
        return arr;
    }
}
