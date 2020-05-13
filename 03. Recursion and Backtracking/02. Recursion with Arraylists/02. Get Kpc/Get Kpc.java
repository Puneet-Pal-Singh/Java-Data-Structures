import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        ArrayList<String> ans = getKPC(str);
        System.out.println(ans);
    }
    
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        
    public static ArrayList<String> getKPC(String ques) {
        
        if( ques.length() == 0 ){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        
        ArrayList<String> recAns = getKPC( ques.substring(1) );
        ArrayList<String> myAns = new ArrayList<>();
        
        int idx = ques.charAt(0) - '0';
        String word = codes[idx];
        
        for( int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            for( int j = 0; j< recAns.size(); j++ ){
                myAns.add(ch + recAns.get(j) );
            }
        }
        return myAns;
    }
}


/*
        Input---
        78
        
        Output--
        [tv, tw, tx, uv, uw, ux]

*/