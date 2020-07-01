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
        int dest = Integer.parseInt(br.readLine());

        // write all your codes here

        printallpath(graph, src, dest, new boolean[graph.length], "");
    }
    
    public static void printallpath(ArrayList < Edge > [] graph, int src, int dest, boolean[] visited, String path) {
        // code
        
        if (src == dest) {
            System.out.println(path + src);
            return;
        }
        
        visited[src] = true;
        for (int e = 0; e < graph[src].size(); e++) {       //edge
            Edge ce = graph[src].get(e);                    // current edge
            if (visited[ce.nbr] == false)
                printallpath(graph, ce.nbr, dest, visited, path + src);
        }
        visited[src] = false;
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
        4 5 10
        5 6 10
        4 6 10
        2 5 10
        0
        6
        
        Sample Output
        
        012546
        01256
        032546
        03256
*/