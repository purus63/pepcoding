package Graph;

import java.util.ArrayList;
import java.util.Scanner;

class ArticulationPoint {
    static int parent[];
    static int disc[];
    static int low[];
    static boolean visited[];
    static boolean isart[];
    static int time=0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<m;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<n;i++)
        {
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        parent = new int[m];
        disc= new int[m];
        low = new int[m];
        visited = new boolean[m];
        isart = new boolean[m];
        time=0;

        parent[0]=-1;
        dfs(0,graph);
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(isart[i])
                ans++;
        }

        System.out.println(ans);
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
            if(visited[nbr])
                low[u]=Math.min(low[u],disc[nbr]);
            else if(nbr==parent[u])
                continue;
            else
            {
                parent[nbr]=u;
                dfs(nbr,graph);
                low[u]=Math.min(low[u],low[nbr]);
                if(parent[u]==-1)
                {
                    if(cnt>=2)
                    {
                        isart[u]=true;
                    }
                }
                else if(low[nbr]>=disc[u])
                {
                    isart[u]=true;
                }
            }

        }

    }
}
