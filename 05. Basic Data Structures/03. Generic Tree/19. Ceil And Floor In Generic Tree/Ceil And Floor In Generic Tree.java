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


    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    public static void ceilAndFloor(Node temp, int data) {
        // write your code here
        
        if (temp.data > data) {     // ceil = min (all values > data);
            if (temp.data < ceil){
                ceil = temp.data;
            }
        }
        
        if (temp.data < data) {     // floor = max (all values < data);
            if (temp.data > floor){
                floor = temp.data;
            }
        }
        
        for (int i = 0; i < temp.children.size(); i++){
            ceilAndFloor( temp.children.get(i), data );
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        ceilAndFloor(root, data);
        System.out.println("CEIL = " + ceil);
        System.out.println("FLOOR = " + floor);
    }

}

/*
        Sample Input
        
        24
        10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
        70
        
        Sample Output
        
        CEIL = 90
        FLOOR = 60

*/