import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println( isDuplicate( str ) );
    }
    
    public static boolean isDuplicate( String str ){
        Stack<Character> st = new Stack<>();
        
        for( int i = 0; i < str.length() ; i++ ){
            char ch = str.charAt(i);
            
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
