import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList < String > ans = gss(str);
        System.out.println(ans);
    }

    // bc -> [--, -c, b-,bc ]
    // abc -> [---, --c, -b-,-bc, a--, a-c, ab-,abc]  
    public static ArrayList < String > gss(String str) {

        if (str.length() == 0) { // length function for string
            ArrayList < String > baseAns = new ArrayList < > ();
            baseAns.add(""); // empty string has one subsequence that/which is blank.
            return baseAns;
        }

        ArrayList < String > recAns = gss(str.substring(1));

        // 0th character
        char ch = str.charAt(0);

        // Making var for storing char
        ArrayList < String > myAns = new ArrayList < > ();

        for (int i = 0; i < recAns.size(); i++) {
            myAns.add(recAns.get(i));
        }

        for (int i = 0; i < recAns.size(); i++) {
            myAns.add(ch + recAns.get(i));
        }

        /*
        
        char ch = str.charAt(0); // a
    	string restStr = str.substring(1); // bc
    	ArrayList<String> recAns = gss(restStr); // [--, -c, b-,bc ]
    
    	ArrayList<String> myAns = new ArrayList<>();
    	for(String restStr: recAns){
    		myAns.add("" + restStr);
    		myAns.add(ch + restStr);
    	}
    	
    	*/

        return myAns;
    }
}



/*
        Input---
        
        abc
        
        Output---
        
        [, c, b, bc, a, ac, ab, abc]

*/
