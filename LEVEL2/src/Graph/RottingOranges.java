package Graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RottingOranges {

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

            System.out.println(orangesRotting(arr));

        }

        public static class Pair {
            int row;
            int col;

            Pair(int row, int col) {
                this.row = row;
                this.col = col;
            }

        }

    public static int orangesRotting(int[][] grid) {

        res=0;
        int time[][] = new int[grid.length][grid[0].length];
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int[] row:time)
            Arrays.fill(row,1000000);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    dfs(grid,time,visited,i,j,0);
                }
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1 && time[i][j]==1000000)
                    return -1;
                if(grid[i][j]!=0)
                {
                    res=Math.max(res,time[i][j]);
                }
            }
        }
        return res;

    }
    static int x[]={-1,0,1,0};
    static int y[]={0,-1,0,1};
    static int res=0;
    static void dfs(int grid[][],int time[][],boolean visited[][],int r,int c,int t)
    {

        visited[r][c]=true;
        if(time[r][c]==t)
        {
            visited[r][c]=false;
            return;
        }
        time[r][c]= Math.min(time[r][c],t);

        for(int i=0;i<4;i++)
        {
            int rr=r+y[i];
            int cc=c+x[i];

            if(rr>=0 && rr<grid.length && cc>=0 && cc<grid[0].length && grid[rr][cc]==1 && !visited[rr][cc])
            {
                dfs(grid,time,visited,rr,cc,t+1);
            }

        }

        visited[r][c]=false;
    }
    }