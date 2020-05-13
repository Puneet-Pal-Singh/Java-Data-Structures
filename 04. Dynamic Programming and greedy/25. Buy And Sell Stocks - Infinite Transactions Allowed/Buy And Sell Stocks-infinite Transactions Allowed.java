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
        
        int profit = 0;
        for( int i = 1; i < n ; i++ ){
            if( price[i] > price[i - 1] ){
                profit += price[i] - price[ i - 1 ];
            }
        }
        System.out.println( profit );
    }
}

/*
        Input---
        
        9
        11 6 7 19 4 1 6 18 4
        
        Output---
        
        30
*/