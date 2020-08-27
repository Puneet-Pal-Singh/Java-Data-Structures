import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        conversion(exp);
    }

    public static void conversion(String exp) {
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> optrs = new Stack<>();

        for( int i = 0; i < exp.length(); i++ ) {
            char ch = exp.charAt(i);

            if( isDigit(ch) ) {
                postfix.push( "" + ch );
                prefix.push( "" + ch );
            } else if( ch == '(' ) {
                optrs.push(ch);
            } else if( ch == ')' ) {

                while( optrs.peek() != '(' ) {
                    char optr = optrs.pop();

                    // Prefix soln
                    String preop2 = prefix.pop();
                    String preop1 = prefix.pop();
                    prefix.push(optr + preop1 + preop2);

                    // Postfix soln
                    String postop2 = postfix.pop();
                    String postop1 = postfix.pop();
                    postfix.push(postop1 + postop2 + optr);

                }
                optrs.pop();

            } else if(ch == '-' || ch == '+' || ch == '*' || ch == '/') {

                while(optrs.size() > 0 && optrs.peek() != '(' && preced(optrs.peek()) >= preced(ch)) {
                    char optr = optrs.pop();

                    // Prefix soln
                    String preop2 = prefix.pop();
                    String preop1 = prefix.pop();
                    prefix.push(optr + preop1 + preop2);

                    // Postfix soln
                    String postop2 = postfix.pop();
                    String postop1 = postfix.pop();
                    postfix.push(postop1 + postop2 + optr);

                }
                optrs.push(ch);
            }
        }

        while(optrs.size() > 0) {
            char optr = optrs.pop();
            // Prefix soln
            String preop2 = prefix.pop();
            String preop1 = prefix.pop();
            prefix.push(optr + preop1 + preop2);

            // Postfix soln
            String postop2 = postfix.pop();
            String postop1 = postfix.pop();
            postfix.push(postop1 + postop2 + optr);

        }

        System.out.println( postfix.peek() );
        System.out.println( prefix.peek() );
    }

    public static boolean isDigit( char ch ) {
        if( (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') ){
            return true;
        }else{
            return false;
        }
    }

    public static int preced( char optr ) {
        if( optr == '-' || optr == '+' ){
            return 1;
        }else{
            return 2;
        }
    }
}

/*
        
        Sample Input
        
        2 + 6 * 4 / 8 - 3
        
        Sample Output
        
        264*8/+3-
        -+2/*6483
        
*/