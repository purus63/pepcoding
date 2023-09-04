package XYZ.skellum.Grab;

public class Grab1 {
    public static void main(String[] args) {
        int arr[]= {1,2,3,4,5};

        System.out.println(sol(arr));

    }

    private static int sol(int[] arr) {

        int ans=0;
        int sum[]= new int[arr.length];
        sum[0]=arr[0];
        if(sum[0]==1)
            ans=1;
        for(int i=1;i<arr.length;i++)
        {
            sum[i]=sum[i-1]+arr[i];
            if(sum[i]==((i+1)*(i+2))/2)
            {
                ans++;
            }
        }
        return ans;
    }
}
