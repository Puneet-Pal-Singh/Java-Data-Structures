import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
           
        int [][] arr = new int[n][m];
           
        for(int i = 0; i < n; i++ ){  
            for(int j = 0; j < m; j++){
               arr[i][j] = scn.nextInt();  
            }
        }
        for(int j = 0; j < arr[0].length ; j++){
            if(j % 2 == 0){
                for( int i = 0; i < arr.length; i++){
                    System.out.println(arr[i][j]);
                }
            }else{
                for( int i = arr.length - 1; i >= 0 ; i--){
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}


/*
        Sample Input
        
        3
        4
        11 12 13 14
        21 22 23 24
        31 32 33 34
        
        Sample Output
        
        11 21 31 32
        22 12 13 23
        33 34 24 14
*/