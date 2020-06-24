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

    public static ArrayList < Node > findNTRP(Node temp, int val) {
        ArrayList < Node > ans = new ArrayList < > ();
        if (temp == null) {
            return ans;
        } else if (temp.data == val) {
            ans.add(temp);
            return ans;
        }

        ArrayList < Node > left = findNTRP(temp.left, val);
        if (left.size() > 0) {
            left.add(temp);
            return left;
        }

        ArrayList < Node > right = findNTRP(temp.right, val);
        if (right.size() > 0) {
            right.add(temp);
            return right;
        }
        return ans;
    }

    public static void printKdown(Node temp, Node blockage, int k) {
        if (temp == null) {
            return;
        } else if (k == 0) {
            System.out.println(temp.data);
            return;
        }
        if (temp.left != blockage) {
            printKdown(temp.left, blockage, k - 1);
        }
        if (temp.right != blockage) {
            printKdown(temp.right, blockage, k - 1);
        }
    }

    public static void printKNodesFar(Node temp, int data, int k) {
        // write your code here
        
        ArrayList < Node > ntrp = findNTRP(temp, data);
        for (int i = 0; i < ntrp.size() && i <= k; i++) {
            Node blockage = null;
            if (i > 0) {
                blockage = ntrp.get(i - 1);
            }
            printKdown(ntrp.get(i), blockage, k - i);
        }
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

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }

}


/*
        Sample Input
        
        19
        50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
        37
        2
        
        Sample Output
        
        12
        50

*/