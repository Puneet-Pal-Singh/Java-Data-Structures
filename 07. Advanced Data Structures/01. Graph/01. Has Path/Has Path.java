import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;        // source
        int nbr;        // neighbour
        int wt;         // weight

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
        int dest = Integer.parseInt(br.readLine());

        // write your code here
        boolean ans = hasPath(graph, src, dest, new boolean[graph.length]);
        System.out.println(ans);
    }
    
    public static boolean hasPath(ArrayList < Edge > [] graph, int src, int dest, boolean[] visited) {
        // code
        if (src == dest){
            return true;
        }
        
        visited[src] = true;
        
        for (int e = 0; e < graph[src].size(); e++) {       // edge
            Edge ce = graph[src].get(e);                    // current edge
            
            if ( visited[ce.nbr] == false ) {
                boolean recAns = hasPath(graph, ce.nbr, dest, visited);
                if (recAns) {
                    return true;
                }
            }
        }
        return false;
    }

}

/*
        Sample Input
        
        7
        8
        0 1 10
        1 2 10
        2 3 10
        0 3 10
        3 4 10
        4 5 10
        5 6 10
        4 6 10
        0
        6
        
        Sample Output
        
        true
*/