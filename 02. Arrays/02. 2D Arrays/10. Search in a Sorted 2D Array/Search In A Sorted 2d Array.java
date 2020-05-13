import java.io.*;
import java.util.*;

public class Main {
    
    public static void searchIn2D( int[][] arr , int data ){
        
        int i = 0 , j = arr[0].length - 1;
        while( i >= 0 && i < arr.length && j >= 0 && j < arr[0].length ){
            if( arr[i][j] == data ){
                System.out.println(i);
                System.out.println(j);
                return;
            }
            else if( arr[i][j] > data ){
                j--;
            }
            else if( arr[i][j] < data ){
                i++;
            }   
        }
        
        /*  ------------Giving Time Limit Exceeded--------------       
        for( int i = 0 ; i < arr.length ; i++ ){
            for( int j = 0 ; j < arr[0].length ; j++ ){
            
                if( arr[i][j] == data ){
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
                else if( arr[i][j] > data ){
                    j--;
                }
                else if( arr[i][j] < data ){
                    i++;
                }    
            }
        }
       */        

        System.out.println("Not Found");
    }
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        
        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int data = scn.nextInt();
        searchIn2D(arr , data);
    }
}


/*
    Input---
    
    4
    11 12 13 14
    21 22 23 24
    31 32 33 34
    41 42 43 44
    43
    
    Output---
    
    3
    2
*/