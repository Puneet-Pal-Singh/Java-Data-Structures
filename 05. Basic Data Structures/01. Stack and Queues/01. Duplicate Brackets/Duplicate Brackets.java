import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        System.out.println( isDup( exp ) );
    }
    
    public static boolean isDup( String exp ){
        Stack<Character> st = new Stack<>();
        
        for( int i = 0; i < exp.length() ; i++ ){
            char ch = exp.charAt(i);
            
            if( ch == ')' ){
                if( st.peek() == '(' ){
                    return true;
                }
                else{
                    while( st.peek() != '(' ){
                        st.pop();
                    }
                    st.pop();
                }
            }
            else{
                st.push( ch );
            }
        }
        return false;
    }

}

/*
    Sample Input
    (a + b) + ((c + d))
    
    Sample Output
    true
*/