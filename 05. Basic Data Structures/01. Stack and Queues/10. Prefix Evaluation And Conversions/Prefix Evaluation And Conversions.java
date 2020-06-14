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
        Stack<Integer> eval = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<String> infix = new Stack<>();
        for( int i = exp.length() - 1 ; i >= 0 ; i-- )
        {
            char ch = exp.charAt(i);
            if(ch >= '0' && ch <= '9' )
            {
                eval.push( ch - '0' );
                postfix.push( "" + ch );
                infix.push( "" + ch );
            }
            else
            {   //eval
                int n1 = eval.pop();
                int n2 = eval.pop();
                
                eval.push( solve( ch, n1, n2 ) );
                
                //infix
                String inop1 = infix.pop();
                String inop2 = infix.pop();
                
                infix.push( "(" + inop1 + ch + inop2 + ")" );
                
                //postfix
                String postop1 = postfix.pop();
                String postop2 = postfix.pop();
                
                postfix.push( postop1 + postop2 + ch );
            }
        }
        System.out.println( eval.peek() );
        System.out.println( infix.pop() );
        System.out.println( postfix.pop() );
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
        else{ 
            return v1 / v2;
        }
    }
}


/*

        Sample Input

        -+2/*6483

        Sample Output

        2
        ((2+((6*4)/8))-3)
        264*8/+3-

*/