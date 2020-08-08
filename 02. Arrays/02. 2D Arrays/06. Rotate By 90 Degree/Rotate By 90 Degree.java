import java.io.*;
import java.util.*;

public class Main {
    
    public static void transpose(int[][] arr){
        for(int i = 0; i < arr.length ; i++ ){
            for(int j = i ; j < arr[0].length; j++){      // for(int j = i+1 ; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
           
        int[][] arr = new int[n][n];
           
        for(int i = 0; i < arr.length; i++ ){  
            for(int j = 0; j < arr.length; j++){
               arr[i][j] = scn.nextInt();  
            }
        }
        
        transpose(arr);
        
        // reverse
        /*
        for( int j = 0; j < arr[0].length/2 ; j++){
            for(int i = 0; i < arr.length; i++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][ arr[0].length-1-j ];
                arr[i][ arr[0].length-1-j ] = temp;
            }
        }
        */
        
        // reverse
        for(int i = 0; i < arr.length; i++){
            int li = 0;                     // left index
            int ri = arr[i].length - 1;     // right index
            
            while(li < ri){
                int temp = arr[i][ li ];
                arr[i][ li ] = arr[i][ ri ];
                arr[i][ ri ] = temp;
                
                li++;
                ri--;
            }
        }
        display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}

/*
        Sample Input
        
        4
        11 12 13 14
        21 22 23 24
        31 32 33 34
        41 42 43 44
        
        Sample Output
        
        41 31 21 11
        42 32 22 12
        43 33 23 13
        44 34 24 14
*/
