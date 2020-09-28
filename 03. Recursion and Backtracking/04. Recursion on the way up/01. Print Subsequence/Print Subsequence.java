import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        /*
        String str = scn.next();
        System.out.println( str );
        */   
        
        String str = scn.nextLine();
        // System.out.println( str );
    
        printSS( str , "" );
        System.out.println();
    }

    public static void printSS(String ques, String ans) {
        
        if(ques.length() == 0 ){
            // if( ans.length() != 0 )
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0); //  0th index character
        String roq = ques.substring( 1 );  // rest of qs than 0th index
    
        printSS( roq, ans + ch);
        printSS( roq, ans + "");
    }

}

/*
        Sample Input
        
        abc
        
        Sample Output
        
        abc
        ab
        ac
        a
        bc
        b
        c

*/
