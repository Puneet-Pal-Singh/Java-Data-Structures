import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println( isBalBracket( str ) );
    }
    public static boolean isBalBracket(String str)
    {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0 || st.peek() != '(') {
                    return false;
                } else {
                    st.pop();
                }
            } else if (ch == '}') {
                if (st.size() == 0 || st.peek() != '{') {
                    return false;
                } else {
                    st.pop();
                }
            } else if (ch == ']') {
                if (st.size() == 0 || st.peek() != '[') {
                   return false;
                } else {
                    st.pop();
                }
            } 
        }

        if (st.size() == 0) {
            return true;
        } else {
            return false;
        }
        //or st.size() > 0 return false return true
    }
}


/*
    Sample Input
    [(a + b) + {(c + d) * (e / f)}]
    
    Sample Output
    true
*/
