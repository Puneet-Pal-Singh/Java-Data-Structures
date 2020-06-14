import java.io.*;
import java.util.*;

public class Main {

    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            // write ur code here
            return tos + 1;
        }

        void display() {
            // write ur code here
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            // write ur code here
            if (tos + 1 == data.length) {
                System.out.println("Stack overflow");
            } else {
                tos++;
                data[tos] = val;
            }
        }

        int pop() {
            // write ur code here
            if (tos == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int rv = data[tos];
                data[tos] = 0;
                tos--;
                return rv;
            }
        }

        int top() {
            // write ur code here
            if (tos == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int rv = data[tos];
                return rv;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomStack st = new CustomStack(n);

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("display")) {
                st.display();
            }
            str = br.readLine();
        }
    }
}


/*
        Sample Input
        
        5
        push 10
        display
        push 20
        display
        push 30
        display
        push 40
        display
        push 50
        display
        push 60
        display
        top
        pop
        display
        top
        pop
        display
        top
        pop
        display
        top
        pop
        display
        top
        pop
        display
        top
        pop
        quit
        
        Sample Output
        
        10
        20 10
        30 20 10
        40 30 20 10
        50 40 30 20 10
        Stack overflow
        50 40 30 20 10
        50
        50
        40 30 20 10
        40
        40
        30 20 10
        30
        30
        20 10
        20 
        20
        10
        10
        10
        
        Stack underflow
        Stack underflow

*/