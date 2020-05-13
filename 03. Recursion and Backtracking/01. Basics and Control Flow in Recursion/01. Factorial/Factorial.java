import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code herent 
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int ans = factorial(n);
        System.out.println(ans);
    }

    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        int nm1 = factorial(n - 1); // n minus 1
        int nfact = nm1 * n;
        return nfact;
    }
}

/*
        Sample Input
        5
        Sample Output
        120
*/