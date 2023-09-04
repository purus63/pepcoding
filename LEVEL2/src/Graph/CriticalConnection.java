package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class CriticalConnection {
    static int parent[];
    static int disc[];
    static int low[];
    static boolean visited[];
    static int time=0;
    static ArrayList<ArrayList<Integer>> al;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<m;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<n;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        parent = new int[m];
        disc= new int[m];
        low = new int[m];
        visited = new boolean[m];
        al= new ArrayList<>();
        time=0;

        parent[0]=-1;
        dfs(0,graph);

        System.out.println(al);
    }

    static void dfs(int u,ArrayList<ArrayList<Integer>> graph )
    {
        visited[u]=true;
        disc[u]=time;
        low[u]=time;
        time++;
        int cnt=0;
        for(int nbr:graph.get(u))
        {
            cnt++;
            if(nbr==parent[u])
                continue;
            else if(visited[nbr])
                low[u]=Math.min(low[u],disc[nbr]);
            else
            {
                parent[nbr]=u;
                dfs(nbr,graph);
                low[u]=Math.min(low[u],low[nbr]);

                if(low[nbr]>disc[u])
                {
                    ArrayList<Integer> n= new ArrayList<>();
                    n.add(u);
                    n.add(nbr);
                    al.add(n);
                }
            }

        }

    }
}
