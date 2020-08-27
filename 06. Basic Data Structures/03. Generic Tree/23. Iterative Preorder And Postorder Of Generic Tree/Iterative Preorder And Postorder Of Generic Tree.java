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

    static class pair {
        Node cn;
        int state;
        pair(Node temp) {
            cn = temp;
            state = -1;
        }
    }
    
    public static void IterativePreandPostOrder(Node root) {
        // write your code here

        Stack < pair > st = new Stack < > ();
        st.push( new pair(root) );
        String pre = "";
        String post = "";
        
        while (st.size() > 0) {
            
            pair currp = st.peek();
            if (currp.state == -1) {
                //preorder
                pre += currp.cn.data + " ";
                currp.state++;
            }
            
            else if ( currp.state < currp.cn.children.size() ) {
                Node child = currp.cn.children.get( currp.state );
                st.push( new pair(child) );
                currp.state++;
            } 
            
            else {
                //postorder
                post += currp.cn.data + " ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(post);
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
        IterativePreandPostOrder(root);
    }

}

/*

        Sample Input
        
        24
        10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
        
        Sample Output
        
        10 20 -50 60 30 70 -80 110 -120 90 40 -100 
        -50 60 20 70 110 -120 -80 90 30 -100 40 10 
        
*/