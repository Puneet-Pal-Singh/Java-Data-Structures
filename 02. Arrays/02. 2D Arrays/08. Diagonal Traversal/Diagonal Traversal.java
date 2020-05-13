import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] arr = new int[n][n];
        
        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                arr[i][j] = scn.nextInt();
            }
        }
        
        for( int diff = 0; diff < arr[0].length ; diff++ ){
            
            for( int i = 0, j = diff ; j < arr[0].length ; i++ , j++ ){
                
                System.out.println( arr[i][j] );
            }
        }
    }
}

/*
        Input---
        
        4
        11 12 13 14
        21 22 23 24
        31 32 33 34
        41 42 43 44
        
        Output--
        
        11
        22
        33
        44
        12
        23
        34
        13
        24
        14

*/