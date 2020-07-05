import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        
        // Code
        boolean isCycle = false;
        boolean[] visited = new boolean[graph.length];
        
        for (int vtx = 0; vtx < graph.length; vtx++) {
            if (visited[vtx] == false) {
                boolean ans = bfs(graph, vtx, visited);
                if (ans == true) {
                    isCycle = true;
                    break;
                }
            }
        }
        //int src = Integer.parseInt(br.readLine());
        System.out.println(isCycle);
    }

    static class pair {
        String path;
        int vtx;
        pair(String p, int v) {
            path = p;
            vtx = v;
        }
    }

    public static boolean bfs(ArrayList < Edge > [] graph, int src, boolean[] visited) {
        
        Queue < pair > qu = new LinkedList < > ();
        qu.add(new pair("" + src, src));
        
        while (qu.size() > 0) {
            pair cp = qu.remove();
            if (visited[cp.vtx]) {
                return true;
            } else {
                visited[cp.vtx] = true;
            }

            for (int e = 0; e < graph[cp.vtx].size(); e++) {
                Edge ce = graph[cp.vtx].get(e);
                if ( visited[ce.nbr] == false ) {
                    qu.add(new pair(cp.path + ce.nbr, ce.nbr));
                }
            }
        }
        return false;
    }
}

/*
        Sample Input
        
        7
        6
        0 1 10
        1 2 10
        2 3 10
        3 4 10
        4 5 10
        5 6 10
        
        Sample Output
        
        false
*/