import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        if (n == 0 || m == 0) {
            System.out.println();
        }

        printMazePaths(1, 1, n, m, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        // TWO WAYS we can solve this qs
/*
        // normal base case and smart calls
        if (sr == dr && sc == dc) {
            System.out.println(psf); // path so far
            return;
        }

        if (sc + 1 <= dc) {
            printMazePaths(sr, sc + 1, dr, dc, psf + 'h');
        }

        if (sr + 1 <= dr) {
            printMazePaths(sr + 1, sc, dr, dc, psf + 'v');
        }
*/
        
        // Smart Base case and Normal calls
        if( sr > dr || sc > dc){
            return;
        }
        
        if( sr == dr && sc == dc){
            System.out.println( psf ); // path so far
            return;
        }
        
        printMazePaths( sr, sc + 1, dr , dc , psf + 'h' );
        printMazePaths( sr + 1, sc, dr , dc , psf + 'v' );
        
    }

}


/*
	    Input---
	    
	    2
	    2
	    
	    Output---
	    
	    hv
            vh
*/
