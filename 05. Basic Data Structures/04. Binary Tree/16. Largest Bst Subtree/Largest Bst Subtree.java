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

    static class bstHelper {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int size = 0;
        Node bstroot = null;
        boolean isbst = true;
    }

    public static bstHelper findLargestBST(Node node) {

        if (node == null) {
            return new bstHelper();
        }

        bstHelper lans = findLargestBST(node.left);
        bstHelper rans = findLargestBST(node.right);
        bstHelper myans = new bstHelper();

        myans.isbst = lans.isbst && rans.isbst && node.data > lans.max && node.data < rans.min;

        if (myans.isbst) {
            myans.bstroot = node;
            myans.size = lans.size + rans.size + 1;

            
            // ---------- You can write this even outside of if else
            if (node.left == null) {
            myans.min = node.data;
            } else {
                myans.min = lans.min;
            }
            if (node.right == null) {
                myans.max = node.data;
            } else {
                myans.max = rans.max;
            }
            // ------------
            
        } else {
            if (lans.size >= rans.size) {
                myans.size = lans.size;
                myans.bstroot = lans.bstroot;
            } else {
                myans.size = rans.size;
                myans.bstroot = rans.bstroot;
            }
        }
        /*
        if (node.left == null) {
            myans.min = node.data;
        } else {
            myans.min = lans.min;
        }
        if (node.right == null) {
            myans.max = node.data;
        } else {
            myans.max = rans.max;
        }
        */
        return myans;
    }

    public static void largestBST(Node root) {
        bstHelper ans = findLargestBST(root);
        System.out.println(ans.bstroot.data + "@" + ans.size);
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

        // write your code here
        largestBST(root);
    }

}

/*
        Sample Input
        
        23
        50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n 87 n n
        
        Sample Output
        
        25@5
*/