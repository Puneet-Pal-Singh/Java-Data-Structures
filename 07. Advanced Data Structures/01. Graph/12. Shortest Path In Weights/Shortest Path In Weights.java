import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        // write your code here
        
        shortestPaths(graph, src);
    }

    static class dhelper implements Comparable < dhelper > {
        int vtx;
        int cost;
        String path;

        dhelper(int vtx, int cost, String path) {
            this.vtx = vtx;
            this.cost = cost;
            this.path = path;
        }
        public int compareTo(dhelper other) {
            // if( this.cost == other.cost ){
            //     return this.vtx = other.vtx;
            // }else{
            return this.cost - other.cost;
            // }
        }
    }

    public static void shortestPaths(ArrayList < Edge > [] graph, int src) {
        
        PriorityQueue < dhelper > pq = new PriorityQueue < > ();
        pq.add(new dhelper(src, 0, "" + src));
        boolean[] visited = new boolean[graph.length];
        
        while (pq.size() > 0) {
            dhelper cp = pq.remove();
            if (visited[cp.vtx] == true) {
                continue;
            } else {
                visited[cp.vtx] = true;
            }
        
            System.out.println(cp.vtx + " via " + cp.path + " @ " + cp.cost);

            for (int e = 0; e < graph[cp.vtx].size(); e++) {
                Edge ce = graph[cp.vtx].get(e);
                if (visited[ce.nbr] == false) {
                    pq.add(new dhelper(ce.nbr, cp.cost + ce.wt, cp.path + ce.nbr));
                }
            }
        }
    }
}

/*
        
        Sample Input
        
        7
        9
        0 1 10
        1 2 10
        2 3 10
        0 3 40
        3 4 2
        4 5 3
        5 6 3
        4 6 8
        2 5 5
        0
        
        Sample Output
        
        0 via 0 @ 0
        1 via 01 @ 10
        2 via 012 @ 20
        5 via 0125 @ 25
        4 via 01254 @ 28
        6 via 01256 @ 28
        3 via 012543 @ 30

*/