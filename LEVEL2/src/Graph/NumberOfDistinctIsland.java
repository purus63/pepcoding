package Graph;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

class NumberOfDistinctIsland {

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

        System.out.println(numDistinctIslands(arr));

    }

    public static StringBuilder psf = new StringBuilder();


    static int x[]={-1,0,1,0};
    static int y[]={0,-1,0,1};
    static char ch[] = {'l','u','r','d'};
    public static int numDistinctIslands(int[][] arr) {


        HashSet<String> hset= new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==1)
                {
                    psf=new StringBuilder("x");
                    dfs(arr,i,j,psf,hset);
                    hset.add(psf.toString());
                }
            }
        }
        return hset.size();
    }
    public static void dfs(int [][] arr,int r,int c,StringBuilder psf,HashSet<String> hset)
    {
        arr[r][c]=0;
        for(int i=0;i<4;i++)
        {
            int rr = r+y[i];
            int cc = c+x[i];

            if(rr>=0 && rr<arr.length && cc>=0 && cc<arr[0].length && arr[rr][cc]==1)
            {
                psf.append(ch[i]+"");
                dfs(arr,rr,cc,psf,hset);
            }
        }
        psf.append("y");
    }
}