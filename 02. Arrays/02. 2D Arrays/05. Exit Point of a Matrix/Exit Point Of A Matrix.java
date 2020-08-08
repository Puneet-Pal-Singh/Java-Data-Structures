import java.io.*;
import java.util.*;

public class Main {
    
    public static void exitPoint(int[][] arr){
        
        int r = 0 , c = 0, dir = 0; //initial position
        
        //if written in while we say if true only then works therfore below last if conditions reverse
        while(true){
            dir += arr[r][c];
            dir = dir % 4;
            
            if(dir == 0){       // East
                c++;
            }else if(dir==1){   // South
                r++;
            }else if(dir==2){   // West 
                c--;
            }else if(dir==3){   // North
                r--;
            }
            
            /* 
            if(r < 0 || r == arr.length || c < 0 || c == arr[0].length){
                break; // this will when will loop stops
            }
            */
        

            if( r < 0){
                r++;              
                break;
            }else if(c < 0){
                c++;
                break;
            }else if(r == arr.length){
                r--;
                break;
            }else if(c == arr[0].length){
                c--;
                break;
            }
            // as pointer will first exit and then print exited and we have to print the exited point 
            // therefore for telling the last pointer we are adjusting by inc or dec "r" and "c"
        }    
        
        System.out.println(r);
        System.out.println(c);
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
           
        int[][] arr = new int[n][m];
           
        for(int i = 0; i < n; i++ ){  
            for(int j = 0; j < m; j++){
               arr[i][j] = scn.nextInt();  
            }
        }
        exitPoint(arr);
    }

}

/*
        Sample Input
        
        4
        4
        0 0 1 0
        1 0 0 0
        0 0 0 0
        1 0 1 0
        
        Sample Output
        
        1
        3
*/
