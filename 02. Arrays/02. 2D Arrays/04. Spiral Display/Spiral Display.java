import java.io.*;
import java.util.*;

public class Main {
    
     public static void spiralDis(int[][] arr){
         
        int minr = 0, minc = 0;
        int maxr = arr.length-1 , maxc = arr[0].length-1;
        int total_ele = arr.length * arr[0].length;         // n * m
        int c_ele = 0;
        
        while(c_ele < total_ele){
            
            //left wall
            for(int i = minr; i <= maxr && c_ele < total_ele; i++){
                System.out.println(arr[i][minc]);
                c_ele++;
            }
            minc++;
            
            //bottom wall
            for(int i = minc; i <= maxc && c_ele < total_ele; i++){
                System.out.println(arr[maxr][i]);   
                c_ele++;
            }
            maxr--;
            
            // rightwall
            for(int i = maxr; i >= minr && c_ele < total_ele; i--){
                System.out.println(arr[i][maxc]);   
                c_ele++;
            }
            maxc--;
            
            // topwall
            for(int i = maxc; i >= minc && c_ele < total_ele; i--){
                System.out.println(arr[minr][i]);   
                c_ele++;
            }
            minr++;
        }


        /*
        while(c_ele < total_ele){
            
            //left wall
            for(int i = minr, j = minc; i <= maxr && c_ele < total_ele; i++){
                System.out.println(arr[i][j]);
                c_ele++;
            }
            minc++;
            
            //bottom wall
            for(int i = maxr, j = minc; j <= maxc && c_ele < total_ele; j++){
                System.out.println(arr[i][j]);   
                c_ele++;
            }
            maxr--;
            
            // rightwall
            for(int i = maxr, j = maxc; i >= minr && c_ele < total_ele; i--){
                System.out.println(arr[i][j]);   
                c_ele++;
            }
            maxc--;
            
            // topwall
            for(int i = minr, j = maxc; j >= minc && c_ele < total_ele; j--){
                System.out.println(arr[i][j]);   
                c_ele++;
            }
            minr++;
        }
        */
    }

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
        spiralDis(arr);
    }

}

/*
        
        Sample Input
        
        3
        5
        11 12 13 14 15
        21 22 23 24 25
        31 32 33 34 35
        
        Sample Output
        
        11 21 31 32 33
        34 35 25 15 14
        13 12 22 23 24

*/
