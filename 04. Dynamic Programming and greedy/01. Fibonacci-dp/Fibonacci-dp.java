import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        /*
        // Recursive
        
        int ans = fib(n);
        System.out.println(ans);
        
        // DP with Memoisation
        
        int[] dp = new int[n+1];
        int ans1 = fibDP(n,dp);
        System.out.println(ans1);
        */
        
        //DP with Tabulation
        int ans2 = fibT(n);
        System.out.println(ans2);
    }
    
    // DP with tabulation
    public static int fibT(int n){
        if(n==1 || n==0){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for( int i = 2; i <= n; i++ ){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    //DP with Memoisation
    public static int fibDP(int n , int[] dp){
        if(n==1 || n==0){
            return n;
        }else if(dp[n] != 0){
            return dp[n];
        }
        int nm1 = fibDP(n-1 , dp);
        int nm2 = fibDP(n-2 , dp);
        int myans = nm1 + nm2;
        dp[n] = myans;
        return myans;
    }
    
    // Recursion
    public static int fib(int n){
        if(n==1 || n==0){
            return n;
        }
        int nm1 = fib(n-1);
        int nm2 = fib(n-2);
        int myAns = nm1 + nm2;
        return myAns;
    }
}


/*
        Input---
        
        10
        
        Output---
        
        55
*/