import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack < Pair > st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }
    
    // Right approach but not efficient O [n^2] - 
    // It has 2 times recursion in post order One in calc height and sec in this func.
    
    /*
    public static int diameter1(Node node) {
        // write your code here
        if (node == null) {
                return 0;
            }
        // max distance between two nodes of LHS
        int ld = diameter1(node.left);

        // max distance between two nodes of RHS
        int rd = diameter1(node.right);

        // max distance between left's deepest and right's node
        int lh = height(node.left);
        int rh = height(node.right);
        int d = lh + rh + 2;

        int myDia = Math.max(d, Math.max(ld, rd));
        return myDia;
    }

    */
    
    // This approach is O[1] - It has no recursion
    static class DiaPair {
        int ht; // height
        int dia; // diameter
    }

    public static DiaPair diameter2(Node node) {
        if (node == null) {
            DiaPair basePair = new DiaPair();
            basePair.ht = -1;
            basePair.dia = 0;
            return basePair;
        }

        DiaPair lPair = diameter2(node.left); 
        DiaPair rPair = diameter2(node.right); 

        DiaPair myPair = new DiaPair();

        myPair.ht = Math.max(lPair.ht, rPair.ht) + 1;

        // diameter on each side crossing node
        int dia2Side = lPair.ht + rPair.ht + 2;  

        myPair.dia = Math.max( dia2Side, Math.max(lPair.dia, rPair.dia));

        return myPair;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        // int diameter = 0;
        // diameter = diameter1(root);
        // System.out.println(diameter);
        
        DiaPair p = diameter2(root);
        System.out.println(p.dia);
    }

}

/*
        Sample Input
        
        19
        50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
        
        Sample Output
        
        6
*/
