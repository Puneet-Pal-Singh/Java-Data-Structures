import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;   // default = 0
        Node next;  // default = null
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            // Write your code here
            
            Node nn = new Node();
            nn.data = val;
            if ( size == 0 ){   // or head == null
                head = nn;
                tail = nn;
            }else{
                tail.next = nn;
                tail = nn;  	// tail = tail.next
            }
            size++;
        }
    }

    public static void testList(LinkedList list) {
        for (Node temp = list.head; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
        System.out.println(list.size);

        if (list.size > 0) {
            System.out.println(list.tail.data);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }
            str = br.readLine();
        }

        testList(list);
    }
}

/*
        
        Sample Input
        
        addLast 10
        addLast 20
        addLast 30
        addLast 40
        addLast 50
        quit
        
        Sample Output
        
        10
        20
        30
        40
        50
        5
        50
*/