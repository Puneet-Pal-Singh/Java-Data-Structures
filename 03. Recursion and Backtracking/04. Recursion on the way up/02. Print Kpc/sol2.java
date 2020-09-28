// This program has minor changes, understand variable is defined as `static` when defined outside main method

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String keys = scn.next();
        
        printKPC( keys, "");
    }
    
    // codes variable will be static  
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printKPC(String ques, String ans) {
        
        if( ques.length() == 0 ){
            System.out.println(ans);
            return;
        } 
        
        // char ch = ques.charAt(0);
        // int idx = ch - '0';
        
        int idx = ques.charAt(0) - '0';     // 49 - 48 = 1 , 7 - 0 = 7
        
        String roq = ques.substring(1);     // 7 , ""
        
        String word = codes[idx];           //  t u , a b c
        
        for( int i = 0; i < word.length(); i++ ){
            char ch = word.charAt(i);
            
            printKPC( roq, ans + ch );
        }
    }

}



/*
    Input---
    7
    
    Output---
    t
    u

*/
