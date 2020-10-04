import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = countStairsPath(n);
        int[] strg = new int[n+1];
        System.out.println(ans);
        // System.out.println(ans + sp(n) +sp(n,strg) );
    }
    
    //Simple Recursion
    /*
    public static int sp(int n){
        if(n == 0){
            return 1;
        }
        int ans = 0;
        if(n-1 >= 0){
            ans += sp(n-1);
        }
        if(n-2 >= 0){
            ans += sp(n-2);
        }
        if(n-3 >= 0){
            ans += sp(n-3);
        }
        return ans;
    }
    */
    
    // Memoisation
    
    public static int sp(int n , int[] strg){
        if(n == 0){
            return 1;
        }
        else if( strg[n] != 0 ){
            return strg[n];
        }
        
        int ans = 0;
        if(n-1 >= 0){
            ans += sp(n-1,strg);
        }
        if(n-2 >= 0){
            ans += sp(n-2,strg);
        }
        if(n-3 >= 0){
            ans += sp(n-3,strg);
        }
        strg[n] = ans;
        return ans;
    }
    
    // Tabulation
    public static int countStairsPath(int n){
        int[] strg = new int[n+1];
        strg[0] = 1;
        for( int i = 1 ; i <= n ; i++){
            int count = 0;
            if(i - 1 >= 0){
                count += strg[i-1];
            }
            if(i - 2 >= 0){
                count += strg[i-2];
            }
            if(i - 3 >= 0){
                count += strg[i-3];
            }
            strg[i] = count;
        }
        return strg[n];
    }
}


/*
        Input---
        
        4
        
        
        Output---
        
        7

*/
