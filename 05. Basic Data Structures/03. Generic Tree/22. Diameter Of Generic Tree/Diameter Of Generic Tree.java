import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    static int dia = 0;
    public static int heightWithDia(Node temp) {
        int maxh = -1;
        int smaxh = -1;
        
        for (int i = 0; i < temp.children.size(); i++) {
            
            int ch = heightWithDia( temp.children.get(i) );
            
            if (ch >= maxh) {       // maxh = 5; smax = -1;
                smaxh = maxh;
                maxh = ch;
            } else if (ch > smaxh) {
                smaxh = ch;
            }
        }
        int currd = maxh + smaxh + 2;
        if (currd > dia) {
            dia = currd;
        }
        return maxh + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here

        heightWithDia(root);
        System.out.println(dia);
    }

}


/*
        Sample Input
        
        20
        10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
        
        Sample Output
        
        4
*/