package Recursion;
import java.io.*;




public class TestClass {
    static int sz=530;
    static long[] res= new long[sz];

    public static void recursion(long slot[],int n,int maxi,int idx)
    {
        if(idx==slot.length)
        {
            res[maxi]=res[maxi]+(slot[1]*slot[3])*(slot[1]+slot[2]+slot[3]);
            return;
        }

        for(int i=1;i<sz;i++)
        {
            if(slot[idx]==0)
            {
                slot[idx]=i;
                maxi=Math.max(i,maxi);
                recursion(slot,n,maxi,idx+1);
                slot[idx]=0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        long slot[] =new long[4];

        recursion(slot,sz,0,1);

        for(int i=1;i<sz;i++)
        {
            res[i]+=res[i-1];
        }

        int cnt=0;
        for(int i=0;i<sz;i++)
        {
            System.out.println(cnt+" "+res[i]);
            cnt++;
        }


        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            long S = Long.parseLong(br.readLine().trim());

            int out_ = solve(S);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    static int solve(long S){
        // Write your code here
        int result=0;
        for(int i=0;i<sz;i++)
        {
            if(res[i]<=S)
            {
                result=i;continue;
            }
            else
                break;
        }
        return result;
    }
}
