package Graph;


import java.io.*;
import java.util.*;


public class MotherVertex{
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            graph.get(u).add(v);
        }

        System.out.println(findMotherVertex(n, graph));
    }
    static Stack<Integer> st;
    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>>adj){
        st= new Stack<>();
        boolean visited[]= new boolean[N];

        int res=1;
        for(int i=0;i<N;i++)
        {
            if(!visited[i])
            {
                res=dfs(adj,visited,i,st);
            }
        }
        Arrays.fill(visited,false);
        dfs(adj,visited,res,st);
        for(boolean b:visited)
        {
            if(!b)
               return -1;
        }
        return res+1;
    }

    private static int dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int v, Stack<Integer> st) {

        visited[v]= true;
        for(int e:adj.get(v))
        {
            if(!visited[e])
                dfs(adj,visited,e,st);
        }
        return v;
    }
}