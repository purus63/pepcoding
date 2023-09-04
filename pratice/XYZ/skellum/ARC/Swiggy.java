package XYZ.skellum.ARC;

import java.util.ArrayList;

public class Swiggy {
    static class Edge{
        int idx;
        int src;
        int dst;

        public Edge(int idx,int src, int dst) {
            this.idx=idx;
            this.src = src;
            this.dst = dst;
        }
    }
    public static void main(String[] args) {

        int [] pickup={1,4};
        int [] drop={5,6};
        int tips[] ={2,5};

        ArrayList<Edge> graph[] = new ArrayList[10000];
        for(int i=0;i<10000;i++)
            graph[i]=new ArrayList<>();

        for(int i=0;i<2;i++)
            graph[pickup[i]].add(new Edge(tips[i],pickup[i],drop[i]));


        boolean visited[] = new boolean[10000];
        int max=-1;
        for(int i=0;i<2;i++)   
        {
            if(!visited[pickup[i]])
                max=Math.max(max,dfs(graph,pickup,drop,tips,pickup[i],visited,0));
        }
        System.out.println(max);
    }

    private static int dfs(ArrayList<Edge>[] graph, int[] pickup, int[] drop,
                           int[] tips, int i, boolean[] visited,int sum) {

        visited[i]=true;
        for(Edge e:graph[i])
        {
            if(!visited[e.dst])
            {
                sum+=dfs(graph,pickup,drop,tips,e.dst,visited,sum)+e.dst-e.src+e.idx;
            }
        }
        return sum;
    }


}
