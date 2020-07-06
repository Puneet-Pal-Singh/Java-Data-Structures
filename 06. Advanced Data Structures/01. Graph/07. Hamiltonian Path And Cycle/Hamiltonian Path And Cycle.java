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

        // write all your codes here

        boolean[] visited = new boolean[graph.length];
        ArrayList < Integer > path = new ArrayList < > ();
        hPAC(graph, src, visited, path);
    }

    public static void hPAC(ArrayList < Edge > [] graph, int src, boolean[] visited, ArrayList < Integer > path) {
        if (path.size() == graph.length - 1) {
            path.add(src);

            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
            }
            boolean isCycle = false;
            int os = path.get(0);

            for (int e = 0; e < graph[src].size(); e++) {
                Edge ce = graph[src].get(e);
                if (ce.nbr == os) {
                    isCycle = true;
                    break;
                }
            }
            if (isCycle) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
            path.remove(path.size() - 1);
            return;
        }

        visited[src] = true;
        path.add(src);

        for (int e = 0; e < graph[src].size(); e++) {
            Edge ce = graph[src].get(e);
            if (visited[ce.nbr] == false) {
                hPAC(graph, ce.nbr, visited, path);
            }
        }
        path.remove(path.size() - 1);
        visited[src] = false;
    }
}

/*
        Sample Input
        
        7
        9
        0 1 10
        1 2 10
        2 3 10
        0 3 10
        3 4 10
        4 5 10
        5 6 10
        4 6 10
        2 5 10
        0
        
        Sample Output
        
        0123456.
        0123465.
        0125643*
        0346521*
*/