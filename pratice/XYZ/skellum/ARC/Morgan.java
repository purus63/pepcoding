package XYZ.skellum.ARC;

import java.util.Arrays;

public class Morgan {
    public static void main(String[] args) {
        int arr[]={3,6,9,15};
        System.out.println(helper(arr));
    }

    private static int helper(int[] snacks) {

        int n=snacks.length;
        int i,d,ans=n,M= Arrays.stream(snacks).max().getAsInt();
        int [] cnt= new int[M+1];

        for(i=0;i<n;i++)cnt[snacks[i]]++;

        int total=0;
        int s1=0;
        for(i=0;i<=M;i++){
            total+=cnt[i];
            s1+=i*cnt[i];
            cnt[i]=total;
        }

        for(d=2;d<=M;d++){
            int s=total*d-s1;
            for(i=0;i<=M&&s<ans;i+=d)
                s+=i*(cnt[Math.min(i+d,M)]-cnt[i]);
            ans=Math.min(ans,s);
        }
        return ans;

    }
}
