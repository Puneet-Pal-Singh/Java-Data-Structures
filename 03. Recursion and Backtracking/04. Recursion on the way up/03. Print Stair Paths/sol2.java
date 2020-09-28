import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths( n , "" );
    }

    public static void printStairPaths(int n, String path) {
        if( n < 0 ){
            return;
        }
        if( n == 0 ){
            System.out.println(path);
            return;
        }
        // We can use any data type, all strings also
        printStairPaths( n - 1 , path + "1");   // String
        printStairPaths( n - 2 , path + 2);     // Integer
        printStairPaths( n - 3 , path + '3');   // character
    }
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
