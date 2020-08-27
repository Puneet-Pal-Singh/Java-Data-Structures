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

    public static int size(Node node) {
        int s = 0;

        for (Node child: node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child: node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child: node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static void traversals(Node temp) {
        // write your code here
        
        if( temp == null ){
            return;
        }
        
        System.out.println( "Node Pre " + temp.data );
        
        for( int i = 0; i < temp.children.size(); i++ ){
            Node child = temp.children.get(i);
            System.out.println( "Edge Pre " + temp.data + "--" + child.data );
            
            traversals( child );
            
            System.out.println( "Edge Post " + temp.data + "--" + child.data );
        }
        System.out.println( "Node Post " + temp.data );
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
        traversals(root);
    }

}


/*
        Sample Input
        
        12
        10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
        
        Sample Output
        
        Node Pre 10
        Edge Pre 10--20
        Node Pre 20
        Node Post 20
        Edge Post 10--20
        Edge Pre 10--30
        Node Pre 30
        Edge Pre 30--50
        Node Pre 50
        Node Post 50
        Edge Post 30--50
        Edge Pre 30--60
        Node Pre 60
        Node Post 60
        Edge Post 30--60
        Node Post 30
        Edge Post 10--30
        Edge Pre 10--40
        Node Pre 40
        Node Post 40
        Edge Post 10--40
        Node Post 10

*/