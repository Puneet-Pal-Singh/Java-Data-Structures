import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        findHFC(str);
    }
    
    public static void findHFC(String str) {
        HashMap < Character, Integer > hm = new HashMap < > ();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch)) {
                int val = hm.get(ch);
                hm.put(ch, val + 1);
            } else {
                hm.put(ch, 1);
            }
        }
        
        char ans = str.charAt(0);
        int hf = hm.get(ans);
        
        for (char ch: hm.keySet()) {
            int val = hm.get(ch);
            if (val > hf) {
                hf = val;
                ans = ch;
            }
        }
        System.out.println(ans);
    }

}

/*
        Sample Input
        
        zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
        
        Sample Output
        
        q
*/