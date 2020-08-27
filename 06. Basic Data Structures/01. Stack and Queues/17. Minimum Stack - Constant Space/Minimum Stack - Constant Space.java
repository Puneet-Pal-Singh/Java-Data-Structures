import java.io.*;
import java.util.*;

public class Main {

    public static class MinStack {
        Stack < Integer > data;
        int min;

        public MinStack() {
            data = new Stack < > ();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if (data.size() == 0) {
                min = val;
                data.push(val);
            } else if (min > val) {
                data.push(2 * val - min);
                min = val;
            } else {
                data.push(val);
            }
        }

        int pop() {
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int pv = data.pop();
                if (pv < min) {
                    int rv = min;
                    min = 2 * min - pv;
                    pv = rv;
                }
                return pv;
            }
        }

        int top() {
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int rv = data.peek();
                if (rv < min) {
                    rv = min;
                }
                return rv;

            }
        }

        int min() {
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return min;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        
        while (str.equals("quit") == false) {
            
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } 
            
            else if (str.startsWith("pop")) {
                int val = st.pop();
                
                if (val != -1) {
                    System.out.println(val);
                }
            }
            
            else if (str.startsWith("top")) {
                int val = st.top();
                
                if (val != -1) {
                    System.out.println(val);
                }
            }
            
            else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
            
            else if (str.startsWith("min")) {
                int val = st.min();
                
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}

/*
        Sample Input
        
        push 10
        push 20
        push 5
        push 8
        push 2
        push 4
        push 11
        top
        min
        pop
        top
        min
        pop
        top
        min
        pop
        top
        min
        pop
        top
        min
        pop
        top
        min
        pop
        top
        min
        pop
        quit
        
        Sample Output
        
        11
        2
        11
        4
        2
        4
        2
        2
        2
        8
        5
        8
        5
        5
        5
        20
        10
        20
        10
        10
        10

*/