package practice;

public class LiftingWeights {
    public static void main(String[] args) {
        int wts[]={1,2,3,4,5,6};
        int maxcap=28;
        System.out.println(helper(wts,maxcap));
    }

    private static int helper(int[] wts, int maxcap) {

        int dp[][] =new int[wts.length+1][maxcap+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0]=0;
        for(int j=0;j<dp[0].length;j++)
            dp[0][j]=0;

        for(int i=1;i< dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(wts[i-1]==j)
                    dp[i][j]=j;
                else if(j<wts[i-1])
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                else
                    dp[i][j]=Math.max(wts[i-1]+dp[i-1][j-wts[i-1]],Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[wts.length][maxcap];
    }
}
