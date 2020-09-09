// It has compilation errors right now


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
/*
    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }
*/
    public static class bstPair {
        boolean isbst;
        int max;
        int min;
    }

    public static bstPair isBst(Node node) {
        if (node == null) {
            bstPair bpair = new bstPair();     // base pair
            //bp.isbst = true;
            bpair.max = Integer.MIN_VALUE;
            bpair.min = Integer.MAX_VALUE;
            return bpair;
        } 

        bstPair lpair = isbst(node.left);  //left pair
        bstPair rpair = isbst(node.right); // right pair
        
        bstPair mypair = new bstPair();    // my pair

        mypair.isbst = lpair.isbst && rpair.isbst &&
                    (node.data >= lpair.max && node.data <= rpair.min);

        mpair.min = Math.min(node.data, Math.min(lpair.min, rpair.min));
        mpair.max = Math.max(node.data, Math.max(lpair.max, rpair.max));

/*
        if (myAns.isbst) {
            if (temp.left == null) {
                myAns.min = temp.data;
            } else {
                myAns.min = lans.min;
            }

            if (temp.right == null) {
                myAns.max = temp.data;
            } else {
                myAns.max = rans.max;
            }
        }
*/
        return mypair;
    }

    public static boolean isTreeBst(Node node) {

        bstPair answer = isbst(node);

        return answer.isbst;
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

        // System.out.println(isbst(root)); 
        System.out.println(isTreeBst(root));
    }

}

/*
        Sample Input
        
        19
        50 25 12 n n 37 30 n n n 75 62 n 49 n n 87 n n
        
        Sample Output
        
        false
*/
