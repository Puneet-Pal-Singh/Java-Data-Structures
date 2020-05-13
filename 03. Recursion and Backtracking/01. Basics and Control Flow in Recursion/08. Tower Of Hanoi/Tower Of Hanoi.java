import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t1 = scn.nextInt();
        int t2 = scn.nextInt();
        int t3 = scn.nextInt();
        
        toh( n, t1, t2, t3 );
    }

    public static void toh(int n, int t1id, int t2id, int t3id){                                                                                          
        // t1 - Source ..... t2 - Destniation ..... t3 - helper
        
        if( n == 0){
            return;
        }
        
        toh( n - 1, t1id, t3id, t2id);    // t1 to t3
        
        System.out.println( n + "[" + t1id + " -> " + t2id + "]");  // move nth from t1 to t2
        
        toh( n - 1, t3id, t2id, t1id);    // n-1 t3(current source) to t2(dest) using source t1 
    }

}

/*
        Sample Input
        
        3
        10
        11
        12
        
        Output---
        
        1[10 -> 11]
        2[10 -> 12]
        1[11 -> 12]
        3[10 -> 11]
        1[12 -> 10]
        2[12 -> 11]
        1[10 -> 11]

*/