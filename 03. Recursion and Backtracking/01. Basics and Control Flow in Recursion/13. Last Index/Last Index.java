import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      
      /*
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }
      
      int x = Integer.parseInt(br.readLine());
      int li = lastIndex(arr, 0, x);
      System.out.println(li);
      */
      
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = scn.nextInt();
      }
      
      int x = scn.nextInt();
      int li = lastIndex(arr, 0, x);
      System.out.println(li);
      
   }

   public static int lastIndex(int[] arr, int idx, int x) {
      if(idx == arr.length){
         return -1;
      }
      /*
      int liisa = lastIndex(arr, idx + 1, x);
      if(liisa != -1){
         return liisa;
      } else if(arr[idx] == x){
         return idx;
      } else {
         return -1;
      }
      */
      
      int liisa = lastIndex(arr, idx + 1, x);
      if(liisa == -1){
         if(arr[idx] == x){
            return idx;
         } else {
            return -1;
         }
      } else {
         return liisa;
      }
      
   }

}



/*
        Sample Input
    
        6
        15
        11
        40
        4
        4
        9
        4
    
        Sample Output
        4
*/
