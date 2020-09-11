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

    // Approach 1 - Travel and Change
/*
    static boolean isBal = true;
    public static int isBalanced(Node node) {
        if (node == null) {
            return 0; // 0 for nodes and -1 for edges
        }

        int lh = isBalanced(node.left); // left height
        int rh = isBalanced(node.right); // right height

        int gap = Math.abs(lh - rh);
        if (gap > 1) {
            isBal = false;
        }

        int th = Math.max(lh, rh) + 1; // total height
        return th;
    }
*/
    
    // Approach 2 - Using Pair Class

    // Either initiate variables in class or in base class both works
    static class pair {

        // int ht = 0;     // 0 for nodes , -1 for edges
        // boolean isbal = true;

        int ht; // 0 for nodes , -1 for edges
        boolean isbal;

    }

    public static pair isTreeBalancedHelper(Node node) {
        // if (node == null) {
        //    return new pair();
        // }

        if (node == null) {
            pair bp = new pair();
            bp.ht = 0;
            bp.isbal = true;
            return bp;
        }

        pair lans = isTreeBalancedHelper(node.left);
        pair rans = isTreeBalancedHelper(node.right);

        pair myAns = new pair();

        // myAns.isbal = lans.isbal && rans.isbal && (lans.ht - rans.ht >= -1 && lans.ht - rans.ht <= 1);

        myAns.isbal = Math.abs(lans.ht - rans.ht) <= 1 && lans.isbal && rans.isbal;

        myAns.ht = Math.max(lans.ht, rans.ht) + 1;

        return myAns;
    }

    public static boolean isTreeBalanced(Node root) {

        pair ans = isTreeBalancedHelper(root);
        return ans.isbal;
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

        // for pair class output
        System.out.println(isTreeBalanced(root));

        // for travel and change output
        // isBalanced(root);
        // System.out.println(isBal);
    }

}

/*
        Sample Input

        21
        50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n n

        Sample Output

        false

*/
