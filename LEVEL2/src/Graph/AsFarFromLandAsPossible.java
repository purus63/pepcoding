package Graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsFarFromLandAsPossible {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(maxDistance(arr));

    }

    public static int maxDistance(int[][] grid) {
        int ans=-1;
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][] = new boolean[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    ans=Math.max(ans,dfs(grid,visited,i,j,0));
                }
            }
        }
        return ans;

    }
    static int x[]={-1,0,1,0};
    static int y[]={0,-1,0,1};
    private static int dfs(int[][] grid, boolean[][] visited, int r, int c,int t) {

        visited[r][c]= true;
        if(grid[r][c]==1) {
            visited[r][c]=false;
            return t;
        }
        int maxi=(int)1e9;
        for(int i=0;i<4;i++)
        {
            int rr= r+y[i];
            int cc = c+x[i];
            if(rr>=0 && rr< grid.length && cc>=0 && cc<grid[0].length && !visited[rr][cc]) {
                maxi=Math.min(maxi,dfs(grid,visited,rr,cc,t+1));
            }
        }
        visited[r][c]= false;
        return maxi;
    }
}
