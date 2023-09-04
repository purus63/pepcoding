package XYZ.skellum.AtoZ;

public class HackerrankAmazon2 {
    public static void main(String[] args) {

        int [][] mat = {{1,0,0},{1,9,0},{1,1,1}};

        System.out.println(minimumDistance(mat));

    }

    static int xdir[]={-1,0,1,0};
    static int ydir[]={0,-1,0,1};

    private static int minimumDistance(int[][] mat) {
        boolean visited[][] = new boolean[3][3];
        int x = dfs(mat,visited,0,0);
        return x-1;
    }
    private static int dfs(int[][] mat, boolean[][] visited, int r, int c) {

        if(mat[r][c]==0)
            return 0;
        if(mat[r][c]==9)
            return 1;

        int ans=0;
        visited[r][c]= true;
        for(int i=0;i<4;i++)
        {
            int rr=r+ydir[i];
            int cc=c+xdir[i];
            if(rr<0 || rr>=mat.length || cc<0 || cc>=mat[0].length || visited[rr][cc] || mat[rr][cc]==0)
                continue;
            int val=dfs(mat,visited,rr,cc);
            if(ans>0)
                val=Math.min(ans,val);
            if(val>=1)
                ans+=val+1;
        }
        return ans;
    }
}
