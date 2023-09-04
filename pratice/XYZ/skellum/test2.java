package XYZ.skellum;

public class test2 {

    /*[ [a,b,c,x]
        [b,t,y,v]
        [u,i,o,p]
        [v,n,m,q]
     ]
     str="abcd" len=4; (not repeated in input string)
     validity()
     */

    public static void main(String[] args) {

        char arr[][]={{'a','b','c','x'},{'b','t','y','v'},{'u','i','o','p'},{'v','n','m','q'}};
        String str= "abvn"; //abvq
        int idx=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==str.charAt(idx))
                {
                    if(dfs(arr,str,idx+1,i,j))
                    {
                        System.out.println("true");
                        return;
                    }
                }
            }
        }
    }
    static int xdir[]={-1,0,1,0};
    static int ydir[]={0,-1,0,1};

    private static boolean dfs(char[][] arr, String str, int idx,int r,int c) {

        boolean flag=false;
        if(idx==str.length())
            return true;
        for(int i=0;i<4;i++)
        {
            for(int len=1;len<4;len++) {
                int rr = r + ydir[i] * len;
                int cc = c + xdir[i] * len;
                if(rr>=0 && cc>=0 && rr<4 && cc<4 && arr[rr][cc]==str.charAt(idx))
                {
                    flag=dfs(arr,str,idx+1,rr,cc);
                    if(flag)
                        return flag;
                }
            }
        }
        return flag;
    }
}
