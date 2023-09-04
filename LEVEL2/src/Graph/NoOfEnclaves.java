package Graph;

import java.util.*;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.lang.*;

class NoOfEnclaves {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(numEnclaves(arr));

    }

    static int x[]={-1,0,1,0};
    static int y[]={0,-1,0,1};
    static int cnt=0;
    public static int numEnclaves(int[][] arr) {

        int res=0;
        for(int i=1;i<arr.length-1;i++)
        {
            for(int j=1;j<arr[0].length-1;j++)
            {
                if(arr[i][j]==1)
                {
                    cnt=1;
                    if(dfs(arr,i,j))
                        res+=cnt;
                }
            }
        }
        return res;
    }

    public static boolean dfs(int arr[][],int r,int c)
    {
        arr[r][c]=0;
        if((r==0 || r==arr.length-1 || c==0 || c==arr[0].length-1))
            return false;
        for(int i=0;i<4;i++)
        {
            int rr = r+y[i];
            int cc = c+x[i];

            if(rr<0 || rr>arr.length-1 || cc<0 || cc>arr[0].length-1 || arr[rr][cc]==0)
                continue;
            else if((rr==0 || rr==arr.length-1 || cc==0 || cc==arr[0].length-1) && arr[rr][cc]==1)
            {
                return false;
            }
            else
            {
                cnt++;
                return dfs(arr,rr,cc);
            }


        }
        return true;
    }

}