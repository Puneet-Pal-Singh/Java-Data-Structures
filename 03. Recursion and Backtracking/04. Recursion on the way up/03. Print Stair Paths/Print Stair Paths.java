
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths( n , "" );
    }

    public static void printStairPaths(int n, String path) {
        if( n == 0 ){
            System.out.println(path);
            return;
        }
        // 1 jump
        if( n - 1 >= 0)   
        {
            printStairPaths( n - 1 , path + "1");  //String
        }
        
        // 2 jump
        // 2 jumps at nth 
        if( n - 2 >= 0)   
        {
            printStairPaths( n - 2 , path + 2);  //Integer
        }
        
        // 3 jump
        if( n - 3 >= 0)   
        {
            printStairPaths( n - 3 , path + '3');  // character
        }
    }
    
    /*
    for( int jump = 1; jump <= 3 && n = jump >= 0 ; jump ++ ){
        printStairPaths( n - jump , path + jump );
    }
    
    } // func end
    and comment all if lines
    */

}



/*
    Input---
    
    4
    
    Output---
    
    1111
    112
    121
    13
    211
    22
    31

*/