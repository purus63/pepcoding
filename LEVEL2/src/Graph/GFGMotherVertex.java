package Graph;

import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
        }
    }
}




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    Stack<Integer> st;
    public  int findMotherVertex(int N, ArrayList<ArrayList<Integer>>adj){
        boolean visited[]= new boolean[N];
        st= new Stack<>();

        int res=1;
        for(int i=0;i<N;i++)
        {
            if(!visited[i])
            {
                dfs(adj,visited,i,st);
            }
        }
        int ans=(int)1e9;
        while(st.size()>0)
        {
            Arrays.fill(visited,false);
            int x=st.pop();
            int cnt=dfs(adj,visited,x,0);
            if(cnt==N)
                ans=Math.min(ans,x);
            else
                break;
        }
        if(ans==1000000000)
            return -1;
        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int v,Stack<Integer>st) {

        visited[v]= true;
        for(int e:adj.get(v))
        {
            if(!visited[e])
                dfs(adj,visited,e,st);
        }
        st.push(v);
    }
    private static int dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int v,int cnt) {
        cnt++;
        visited[v]= true;
        for(int e:adj.get(v))
        {
            if(!visited[e])
                cnt=dfs(adj,visited,e,cnt);
        }
        return cnt;
    }

}