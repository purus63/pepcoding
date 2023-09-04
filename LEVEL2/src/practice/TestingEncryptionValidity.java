package practice;
import java.util.Arrays;


public class TestingEncryptionValidity {
    public static void main(String[] args) {
        int arr[]={2,4,8,2,16,24};
        int res[]=helper(1000,10000,arr);
        System.out.println(res[0]+" "+res[1]);
    }

    private static int[] helper(int instructioncnt, int validityperiod, int[] arr) {

        Arrays.sort(arr);
        boolean visited[] = new boolean[100001];
        int freq[] = new int[100001];

        for(int a:arr)
        {freq[a]++;visited[a]=true;}

        visited[1]=false;
        int dmax=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(i>0 && arr[i]==arr[i-1])
                continue;
            int temp = getdivisorcnt(visited,freq,arr[i]);
            dmax=Math.max(dmax,temp);
        }
        int res[] = new int[2];
        int strength=dmax*(int)1e5;
        res[1]=strength;
        if(strength<=instructioncnt*validityperiod)
            res[0]=1;
        else
            res[0]=0;
        return res;
    }

    private static int getdivisorcnt(boolean[] visited, int[] freq, int val) {
        int cnt=0;
        for(int i=1;i*i<=val;i++)
        {
            if(val%i==0)
            {
                if(visited[i])
                    cnt+=freq[i];
                if(i*i!=val && visited[val/i])
                    cnt+=freq[val/i];
            }
        }
        return cnt;
    }
}
