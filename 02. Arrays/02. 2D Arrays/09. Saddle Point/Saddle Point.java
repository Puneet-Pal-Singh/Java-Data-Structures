import java.io.*;
import java.util.*;

public class Main {
    
    public static void saddlePoint( int[][] arr ){
        for( int i = 0; i < arr.length; i++ ){
            int min = arr[i][0];
            int col = 0;
            
            for( int j = 1 ; j < arr[0].length ; j++ ){
                if( arr[i][j] < min ){
                    min = arr[i][j]; 
                    col = j;
                }
            }
            
            for( int r = 0 ; r < arr.length ; r++ ){
                if( arr[r][col] > min ){
                    col = -1;
                    break;
                }
            }
            
            if( col >= 0 ){
                System.out.println(min);
                return;
            }
        }
        System.out.println("Invalid input");
    }
    
    
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
        saddlePoint(arr);
    }

}

/*
        Input---
        
        4
        11 12 13 14
        21 22 23 24
        31 32 33 34
        41 42 43 44
        
        Output---
        
        41
*/