import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        // printMazePaths( 0, 0, n - 1, m - 1, "");
        printMazePaths( 1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    // jump - move size
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        
        // horizontal jumps
        for( int jump = 1; sc + jump <= dc ; jump++){
            printMazePaths( sr , sc + jump, dr, dc , psf + 'h' + jump );
        }
        
        // vertical jumps
        for( int jump = 1; sr + jump <= dr ; jump++){
            printMazePaths( sr + jump , sc, dr, dc , psf + 'v' + jump );
        }
        
        // diagonal jumps
        for( int jump = 1; sr + jump <= dr && sc + jump <= dc ; jump++){
            printMazePaths( sr + jump , sc + jump, dr, dc , psf + 'd' + jump );
        }
    }

}


/*
        Input---
        
        3
        3
        
        Output---
        
        
        h1h1v1v1
        h1h1v2
        h1v1h1v1
        h1v1v1h1
        h1v1d1
        h1v2h1
        h1d1v1
        h2v1v1
        h2v2
        v1h1h1v1
        v1h1v1h1
        v1h1d1
        v1h2v1
        v1v1h1h1
        v1v1h2
        v1d1h1
        v2h1h1
        v2h2
        d1h1v1
        d1v1h1
        d1d1
        d2

*/
