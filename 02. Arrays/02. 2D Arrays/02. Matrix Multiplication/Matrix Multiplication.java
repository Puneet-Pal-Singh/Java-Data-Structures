import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int r1 = scn.nextInt();
        int c1 = scn.nextInt();
        int[][] arr1 = new int[r1][c1];
        for (int i = 0; i < arr1.length; i++) //i<r1
        {
            for (int j = 0; j < arr1[0].length; j++) //j<c1
            {
                arr1[i][j] = scn.nextInt();
            }
        }
        int r2 = scn.nextInt();
        int c2 = scn.nextInt();
        int[][] arr2 = new int[r2][c2];
        for (int i = 0; i < arr2.length; i++) // i < n2
        {
            for (int j = 0; j < arr2[0].length; j++) // j < m2
            {
                arr2[i][j] = scn.nextInt();
            }
        }

        if (c1 != r2) {
            System.out.println("Invalid input");
            return;
        }
        
        int[][] prd = new int[r1][c2];
        for (int i = 0; i < prd.length; i++) {        // i < r1
            for (int j = 0; j < prd[0].length; j++) {     // j < c2
                for (int k = 0; k < arr2.length; k++) {     // k < c1 or r2
                    prd[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for (int i = 0; i < prd.length; i++) {
            for (int j = 0; j < prd[0].length; j++) {
                System.out.print(prd[i][j] + " ");
            }
            System.out.println();
        }
    }

}


/*

        Sample Input
        2
        3
        10 0 0 
        0 20 0
        
        3 
        4
        1 0 1 0
        0 1 1 2
        1 1 0 0
        
        Sample Output
        
        10 0 10 0
        0 20 20 40
*/
