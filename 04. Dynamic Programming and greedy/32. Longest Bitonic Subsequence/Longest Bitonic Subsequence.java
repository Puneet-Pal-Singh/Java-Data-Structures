import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for( int i = 0; i < n ; i++ ){
            arr[i] = scn.nextInt();
        }
        
        int[] leftlis = new int[n];
        leftlis[0] = 1;
        
        for( int i = 1; i < n ; i++ ){
            int pm = 0;
            
            for( int j = 0; j < n ; j++ ){
                if( arr[i] > arr[j] && pm < leftlis[j] ){
                    pm = leftlis[j];
                }
            }
            leftlis[i] = pm + 1;
        }
        
        int[] rightlis = new int[n];
        rightlis[n-1] = 1;
        
        for( int i = n - 1; i >= 0 ; i-- ){
            int pm = 0;
            
            for( int j = i + 1; j < n ; j++ ){
                if( arr[i] > arr[j] && pm < rightlis[j] ){
                    pm = rightlis[j];
                }
            }
            rightlis[i] = pm + 1;
        }
        
        int maxBL = 0;
        
        for( int i = 0; i < n ; i++ ){
            if( maxBL < leftlis[i] + rightlis[i] - 1 ){
                maxBL = leftlis[i] + rightlis[i] - 1; 
            }
        }
        System.out.println( maxBL );
    }

}

/*
        Input---
        
        10
        10 22 9 33 21 50 41 60 80 1
        
        Output---
        
        7
*/