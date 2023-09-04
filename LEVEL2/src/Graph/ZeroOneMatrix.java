package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ZeroOneMatrix {
    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        int[][] ans = updateMatrix(arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }
    static int x[]={-1,0,1,0};
    static int y[]={0,-1,0,1};
    public static int[][] updateMatrix(int[][] matrix) {

        int m=matrix.length;
        int n=matrix[0].length;

        int ans[][] = new int[m][n];
        //for(int row[]:ans)
         //   Arrays.fill(row,1000000);
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    ans[i][j] = dfs(matrix,visited, i, j,0);
                }
            }
        }
        return ans;
    }

    private static int dfs(int[][] matrix, boolean[][] visited, int r, int c,int t) {

        visited[r][c]= true;
        if(matrix[r][c]==0) {
            visited[r][c]=false;
            return t;
        }
        int res=(int)1e9;
        for(int i=0;i<4;i++)
        {
            int rr= r+y[i];
            int cc= c+x[i];

            if(rr>=0 && rr<matrix.length && cc>=0 && cc<matrix[0].length && !visited[rr][cc])
            {
                res=Math.min(res,dfs(matrix,visited,rr,cc,t+1));
            }

        }
        visited[r][c]=false;
        return res;
    }


}