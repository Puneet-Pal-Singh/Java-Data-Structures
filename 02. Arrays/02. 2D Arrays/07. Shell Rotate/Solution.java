import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int m = scn.nextInt();
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = scn.nextInt();
         }
      }

      int s = scn.nextInt();    // Shell number
      int r = scn.nextInt();    // Rotate
      shellrotate(arr, s, r);
      display(arr);
   }

   public static void shellrotate(int[][] arr, int s, int r) {
      int[] oned = fillOnedFromShell(arr, s);
      rotate(oned, r);
      fillShellFromOned(arr, s, oned);
   }

   public static int[] fillOnedFromShell(int[][] arr, int s) {
      int minr = s - 1;
      int minc = s - 1;
      int maxr = arr.length - s;
      int maxc = arr[0].length - s;
      int size = 2 * (maxr - minr + maxc - minc);
      
      int[] oned = new int[size];

      // left wall
      int idx = 0;
      for (int i = minr, j = minc; i <= maxr; i++) {
         oned[idx] = arr[i][j];
         idx++;
      }

      // bottom wall
      for (int i = maxr, j = minc + 1; j <= maxc; j++) {
         oned[idx] = arr[i][j];
         idx++;
      }

      // right wall
      for (int i = maxr - 1, j = maxc; i >= minr; i--) {
         oned[idx] = arr[i][j];
         idx++;
      }

      // top wall
      for (int i = minr, j = maxc - 1; j >= minc + 1; j--) {
         oned[idx] = arr[i][j];
         idx++;
      }

      return oned;
   }

   public static void fillShellFromOned(int[][] arr, int s, int[] oned ) {
      int minr = s - 1;
      int minc = s - 1;
      int maxr = arr.length - s;
      int maxc = arr[0].length - s;

      
      // left wall
      int idx = 0;
      for (int i = minr, j = minc; i <= maxr; i++) {
         arr[i][j] = oned[idx];
         idx++;
      }

      // bottom wall
      for (int i = maxr, j = minc + 1; j <= maxc; j++) {
         arr[i][j] = oned[idx];
         idx++;
      }

      // right wall
      for (int i = maxr - 1, j = maxc; i >= minr; i--) {
         arr[i][j] = oned[idx];
         idx++;
      }

      // top wall
      for (int i = minr, j = maxc - 1; j >= minc + 1; j--) {
         arr[i][j] = oned[idx];
         idx++;
      }
   }

   public static void rotate(int[] oned, int r) {
      r = r % oned.length;
      if (r < 0) {
         r += oned.length;
      }

      reverse(oned, 0, oned.length - r - 1);
      reverse(oned, oned.length - r, oned.length - 1);
      reverse(oned, 0, oned.length - 1);
   }

   public static void reverse(int[] oned, int li, int ri) {
      while (li < ri) {
         int temp = oned[li];
         oned[li] = oned[ri];
         oned[ri] = temp;

         li++;
         ri--;
      }
   }

   public static void display(int[][] arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[0].length; j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }

}


/*
        Sample Input
        
        5
        7
        11
        12
        13
        14
        15
        16
        17
        21
        22
        23
        24
        25
        26
        27
        31
        32
        33
        34
        35
        36
        37
        41
        42
        43
        44
        45
        46
        47
        51
        52
        53
        54
        55
        56
        57
        2
        3
        
or can also write in this way
	5
	7
	11 12 13 14 15 16 17
	21 22 23 24 25 26 27
	31 32 33 34 35 36 37
	41 42 43 44 45 46 47
	51 52 53 54 55 56 57
	2
	3
        
	Sample Output
        
        11 12 13 14 15 16 17 
        21 25 26 36 46 45 27 
        31 24 33 34 35 44 37 
        41 23 22 32 42 43 47 
        51 52 53 54 55 56 57 
*/
