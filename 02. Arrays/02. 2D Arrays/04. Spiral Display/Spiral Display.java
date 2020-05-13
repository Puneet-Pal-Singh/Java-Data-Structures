import java.io.*;
import java.util.*;

public class Main {
    
     public static void spiralDis(int[][] arr){
         
        int rmin = 0, cmin = 0;
        int rmax = arr.length-1 , cmax = arr[0].length-1;
        int total_ele = arr.length * arr[0].length;
        int c_ele = 0;
        
        while(c_ele < total_ele){
            
            //left wall
            for(int i = rmin; i <= rmax && c_ele < total_ele; i++){
                System.out.println(arr[i][cmin]);   c_ele++;
            }
            cmin++;
            
            //bottomwall
            for(int i = cmin; i <= cmax && c_ele < total_ele; i++){
                System.out.println(arr[rmax][i]);   c_ele++;
            }
            rmax--;
            
            // rightwall
            for(int i = rmax; i >= rmin && c_ele < total_ele; i--){
                System.out.println(arr[i][cmax]);   c_ele++;
            }
            cmax--;
            
            // topwall
            for(int i = cmax; i >= cmin && c_ele < total_ele; i--){
                System.out.println(arr[rmin][i]);   c_ele++;
            }
            rmin++;
        }
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