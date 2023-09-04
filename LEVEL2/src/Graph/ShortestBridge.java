package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestBridge {

    public static class Pair{
        int i;
        int j;
        Pair(int i,int j)
        {
            this.i=i;
            this.j=j;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                arr[i][j] = sc.nextInt();

            Queue<Pair> q= new LinkedList<>();
            boolean visited[][] = new boolean[n][n];
            boolean flag= false;
            for(int i=0;i<n && !flag;i++)
            {
                for(int j=0;j<n && !flag;j++)
                {
                    if(arr[i][j]==1)
                    {
                        dfs(arr,visited,q,i,j);
                        flag=true;
                    }
                }
            }

            int lvl=0;
            while(q.size()>0)
            {
                int len= q.size();
                while(len-- >0)
                {
                    Pair pp = q.remove();

                    for(int i=0;i<4;i++)
                    {
                        int rr=pp.i+x[i];
                        int cc=pp.j+y[i];
                        if(rr>=0 && rr< arr.length && cc>=0 && cc<arr[0].length && !visited[rr][cc] && arr[rr][cc]==1)
                        {
                            System.out.println(lvl);
                            return;
                        }
                        else if(rr>=0 && rr< arr.length && cc>=0 && cc<arr[0].length && !visited[rr][cc] && arr[rr][cc]==0)
                        {
                            q.add(new Pair(rr,cc));
                        }
                    }
                }
                lvl++;
            }

        System.out.println(lvl);
    }
    static int x[]={-1,0,1,0};
    static int y[]={0,-1,0,1};
    private static void dfs(int[][] arr, boolean[][] visited, Queue<Pair> q, int r, int c) {

        visited[r][c]=true;
        q.add(new Pair(r,c));
        for(int i=0;i<4;i++)
        {
            int rr= r+y[i];
            int cc = c+x[i];

            if(rr>=0 && rr<arr.length && cc>=0 && cc<arr[0].length && !visited[rr][cc] && arr[rr][cc]==1)
            {
                dfs(arr,visited,q,rr,cc);
            }
        }

    }
}
