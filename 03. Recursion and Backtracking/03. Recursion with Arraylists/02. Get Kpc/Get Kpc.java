
//  Both answers are good, just play with code

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        ArrayList < String > ans = getKPC(str);
        System.out.println(ans);
    }

    static String[] codes = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };

    public static ArrayList < String > getKPC(String str) {

        if (str.length() == 0) {
            ArrayList < String > baseAns = new ArrayList < > ();
            baseAns.add("");
            return baseAns;
        }

        /*
        ArrayList<String> recAns = getKPC( str.substring(1) );
        ArrayList<String> myAns = new ArrayList<>();
        
        int idx = str.charAt(0) - '0';
        String word = codes[idx];
        
        for( int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            for( int j = 0; j< recAns.size(); j++ ){
                myAns.add(ch + recAns.get(j) );
            }
        }
        
        */

        // char ch = str.charAt(0);
        String restStr = str.substring(1);
        ArrayList < String > recAns = getKPC(restStr);
        ArrayList < String > myAns = new ArrayList < > ();

        int idx = str.charAt(0) - '0';
        String word = codes[idx];

        // Everthing in one line 
        // String word = codes[str.charAt(0) - '0'];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // for( int j = 0; j< recAns.size(); j++ ){
            //     myAns.add(ch + recAns.get(j) );
            // }
            for (String rstr: recAns) {
                myAns.add(ch + rstr);
            }
        }


        return myAns;
    }
}



// Codes
// {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

/*
        Input---
        78
        
        Output--
        [tv, tw, tx, uv, uw, ux]

*/

/*
        Input---
        78
        
        Output--
        [tv, tw, tx, uv, uw, ux]

*/
