package Graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Kosaraju {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m=0,n=0;
        m=sc.nextInt();
        n=sc.nextInt();

        int a=0,b=0;
        ArrayList<ArrayList<Integer>> graph =new ArrayList<>();
        for(int i=0;i<=m;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            graph.get(a).add(b);
        }

        Stack<Integer> st =new Stack<>();
        boolean visited[] = new boolean[m+1];

        for(int i=1;i<=m;i++)
        {
            if(!visited[i])
            {
                dfs(graph,visited,i,st);
            }
        }

        ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>();
        for(int i=0;i<=m;i++)
        {
            ngraph.add(new ArrayList<>());
        }

        for(int i=1;i<=m;i++)
        {
            ArrayList<Integer> al = graph.get(i);
            for(int x:al)
                ngraph.get(x).add(i);
        }
        int cnt=0;
        visited = new boolean[m+1];
        while(!st.isEmpty())
        {
            int top = st.pop();
            if(!visited[top]) {
                dfs(ngraph, visited, top);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v, Stack<Integer> st) {
        visited[v]= true;
        for(int nbr:graph.get(v))
        {
            if(!visited[nbr])
               dfs(graph,visited,nbr,st);
        }
        st.push(v);
    }
    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int v) {
        visited[v]= true;
        for(int nbr:graph.get(v)) {
            if (!visited[nbr])
                dfs(graph, visited, nbr);
        }
    }
}
