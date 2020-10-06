// Tabulation Method
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n =  scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        // size of array -> n + 1 for 0 to n paths 
        int[] dp = new int[n + 1]; 
        
        // at 6 only one path 6 -> 6 therfore 1
        dp[n] = 1;          
        
        // from 6 to 0
        for(int i = n - 1; i >= 0 ; i--){
            // arr[i] contains number of jumps
            // arr[i] = 3 then 3 jumps i,e i+1, i+2, i+3 and storing there sum
            // sum < dp.length - this prevent outside calls
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++ ){
                dp[i] += dp[i + j];
            }
        }
        
        System.out.println(dp[0]);
    }
}
