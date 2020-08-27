import java.io.*;
import java.util.*;

public class Main{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        // code
        System.out.println( eval(exp) );
    }
    
    public static int eval( String exp ){
        Stack<Integer> num = new Stack<>();
        Stack<Character> optrs = new Stack<>();
        
        for( int i = 0; i < exp.length() ; i++ ){
            char ch = exp.charAt(i);
            
            if( ch >= '0' && ch <= '9' ){
                num.push( ch - '0' );
            }else if( ch == '(' ){
                optrs.push( ch );
            }else if( ch == ')' ){
                
                while( optrs.peek() != '(' ){
                    char optr = optrs.pop();
                    int op2 = num.pop();
                    int op1 = num.pop();
                    num.push( solve( optr, op1, op2 ) );
                }
                
                optrs.pop();
            }else if(  ch == '-' || ch == '+' || ch == '*' || ch == '/' ){
                
                while( optrs.size() > 0 && optrs.peek() != '(' && pred( optrs.peek() ) >= pred(ch) ){
                    char optr = optrs.pop();
                    int op2 = num.pop();
                    int op1 = num.pop();
                    num.push( solve( optr, op1, op2 ) );
                }
                
                optrs.push( ch );
            }
        }
        
        while( optrs.size() > 0 ){
            char optr = optrs.pop();
            int op2 = num.pop();
            int op1 = num.pop();
            num.push( solve( optr, op1, op2 ) );
        }
        
        return num.peek();
    }
    
    public static int solve( char optr, int num1, int num2 ){
        if( optr == '-' ){
            return num1 - num2;    
        }else if( optr == '+' ){
            return num1 + num2;    
        }else if( optr == '*' ){
            return num1 * num2;    
        }else{
            return num1 / num2;    
        }
    }
        
    public static int pred( char optr ){    
    
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
        2

*/