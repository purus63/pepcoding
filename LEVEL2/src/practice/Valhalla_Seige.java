package practice;

public class Valhalla_Seige {

    public static void main(String[] args) {
        int m=5;
        int n=5;
        int arr1[]={1,2,1,2,1};
        int arr2[]={3,10,1,1,1};
        System.out.println(solution(m,n,arr1,arr2));
    }

    private static int solution(int m, int n, int[] arr1, int[] arr2) {

        int sum[]= new int[m];
        sum[0]=arr1[0];

        for(int i=1;i<m;i++)
            sum[i]=sum[i-1]+arr1[i];

        int out=0;
        for(int a:arr2)
        {
            int idx= lowerbound(sum,a,0,m-1);

            int res=n-1-idx;
            if(res<0 || (sum[idx]<=a && res==0))
            {
                out=n;
                sum[0]=arr1[0];
                for(int i=1;i<m;i++)
                    sum[i]=sum[i-1]+arr1[i];
            }
            else if(sum[idx]==a)
            {
                out=n-1-idx;
                for(int i=0;i<m;i++)
                {
                    if(sum[i]>=a)
                    {
                        sum[i]=sum[i]-a;break;
                    }
                    else
                    {
                        a=a-sum[i];
                        sum[i]=0;}
                }
            }
            else if(sum[idx]>a)
            {
                out=n-1-idx+1;
                for(int i=0;i<m;i++)
                {
                    if(sum[i]>=a)
                    {
                        sum[i]=sum[i]-a;break;
                    }
                    else
                    {
                        a=a-sum[i];
                        sum[i]=0;}
                }
            }
            System.out.println(out);
        }

        return 0;
    }

    private static int lowerbound(int[] arr, int a, int lo, int hi) {

        if(lo>hi)
            return lo;

        int mid=(lo+hi)/2;
        if(arr[mid]<a)
            return lowerbound(arr,a,mid+1,hi);
        else
            return  lowerbound(arr,a,lo,mid-1);
    }
}
