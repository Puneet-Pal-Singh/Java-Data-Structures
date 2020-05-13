import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i++ ){
            arr[i] = scn.nextInt();
        }
        
        int inc = arr[0];
        int exc = 0;
        
        for( int i = 1 ; i < n ; i++ ){
            int nInc = exc + arr[i];
            int nExc = Math.max( inc, exc );
            inc = nInc;
            exc = nExc;
        }
        System.out.println( Math.max ( inc , exc ) );
    }
}

/*
        Input--
        6
        5
        10
        10
        100
        5
        6
        
        Output--
        116
*/