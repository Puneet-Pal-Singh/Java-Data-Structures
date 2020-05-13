import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];
        for( int i = 0; i < n ; i++ ){
            price[i] = scn.nextInt();
        }
        int tfee = scn.nextInt();
        
        int buyP = 0 - price[0];
        int sellP = 0;
        
        for( int i = 1; i < n ; i++ ){
            int nBuy = Math.max( sellP - price[i] , buyP );
            int nSell = Math.max( price[i] + buyP - tfee, sellP );
            
            buyP = nBuy;
            sellP = nSell;
        }
        System.out.println( sellP );
    }
}

/*
        Input---
        
        12
        10 15 17 20 16 18 22 20 22 20 23 25
        3
        
        Output--
        
        13

*/