import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        evalAndCon(exp);
    }
    public static void evalAndCon(String exp)
    {
        Stack<Integer> eval  = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> infix = new Stack<>();
        
        for( int i = 0 ; i < exp.length() ; i++ )
        {
            char ch = exp.charAt(i);
            if( ch >= '0' && ch <= '9' )
            {
                eval.push( ch - '0' );
                infix.push( "" + ch );
                prefix.push( "" + ch );
            }
            else
            {   //eval
                int op2 = eval.pop();
                int op1 = eval.pop();
                
                eval.push( solve( ch, op1, op2));
                
                //prefix
                String preop2 = prefix.pop();
                String preop1 = prefix.pop();
                
                prefix.push(ch + preop1 + preop2 );
                
                //infix
                String inop2 = infix.pop();
                String inop1 = infix.pop();
                
                infix.push( "(" + inop1 + ch + inop2 + ")" );
            }
        }
        System.out.println( eval.peek() );
        System.out.println( infix.pop() );
        System.out.println( prefix.pop() );
    }
    
    public static int solve(char op, int v1, int v2) 
    {
        if (op == '+'){
            return v1 + v2;
        }
        else if (op == '-'){ 
            return v1 - v2;
        }
        else if (op == '*'){ 
            return v1 * v2;
        }
        else if (op == '/'){ 
            return v1 / v2;
        }
        else{ 
            return 0;
        }
    }
}

/*

        Sample Input

        264*8/+3-

        Sample Output

        2
        ((2+((6*4)/8))-3)
        -+2/*6483

*/