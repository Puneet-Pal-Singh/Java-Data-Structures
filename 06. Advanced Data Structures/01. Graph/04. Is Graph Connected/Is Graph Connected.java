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

        // write your code here
        
        ArrayList < ArrayList < Integer >> comps = new ArrayList < > ();
        boolean[] visited = new boolean[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                ArrayList < Integer > scomp = new ArrayList < > ();
                gcc(graph, i, visited, scomp);
                comps.add(scomp);
            }
        }
        
        if (comps.size() == 1){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    
    public static void gcc(ArrayList < Edge > [] graph, int src, boolean[] visited, ArrayList < Integer > scomp) {
        visited[src] = true;
        scomp.add(src);
        for (int e = 0; e < graph[src].size(); e++) {
            Edge ce = graph[src].get(e);
            if (visited[ce.nbr] == false)
                gcc(graph, ce.nbr, visited, scomp);
        }
    }
}


/*
        Sample Input
        
        7
        5
        0 1 10
        2 3 10
        4 5 10
        5 6 10
        4 6 10
        
        Sample Output
        
        false
*/