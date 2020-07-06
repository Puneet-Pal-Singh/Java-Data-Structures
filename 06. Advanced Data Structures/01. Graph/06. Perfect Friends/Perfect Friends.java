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

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int vtces = n;
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = k;
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        ArrayList < ArrayList < Integer >> comps = new ArrayList < > ();
        // boolean[] visited = new boolean[vtces];
        boolean[] visited = new boolean[graph.length];
        
        // for (int vtx = 0; vtx < vtces; vtx++) {
        for (int vtx = 0; vtx < graph.length; vtx++) {
            if (visited[vtx] == false) {
                ArrayList < Integer > scomp = new ArrayList < > ();
                traverseSComp(graph, scomp, vtx, visited);
                comps.add(scomp);
            }
        }

        int count = 0;
        for (int i = 0; i < comps.size(); i++) {
            int sizeofI = comps.get(i).size();
            
            for (int j = i + 1; j < comps.size(); j++) {
                int sizeofJ = comps.get(j).size();
                
                count += sizeofI * sizeofJ;
            }
        }
        System.out.println(count);
    }

    public static void traverseSComp(ArrayList < Edge > [] graph, ArrayList < Integer > scomp, int src, boolean[] visited) {
        // code
        
        visited[src] = true;
        scomp.add(src);
        
        for (int e = 0; e < graph[src].size(); e++) {
            Edge ce = graph[src].get(e);
            if (visited[ce.nbr] == false) {
                traverseSComp(graph, scomp, ce.nbr, visited);
            }
        }
    }
}


/*
        Sample Input
        
        7
        5
        0 1
        2 3
        4 5
        5 6
        4 6
        
        Sample Output
        16

*/