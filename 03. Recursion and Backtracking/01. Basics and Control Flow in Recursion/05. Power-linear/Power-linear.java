import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        
        int xrn = power(x, n);
        System.out.println(xrn); //x raise to n
    }

    public static int power(int x, int n){
        if( n == 0){
            return 1;
        }
        
        int xrn_m_1 = power(x , n - 1);
        int xrn = xrn_m_1 * x;
        return xrn;
    }
}

/*

        Sample Input
        2
        5
        Sample Output
        32

*/