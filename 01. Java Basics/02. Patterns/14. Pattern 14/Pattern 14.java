import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here ()
           int n = scn.nextInt();
          for(int i = 1; i <= 10; i++){
              System.out.println(n + " * " + i + " = " + (i * n));
           }
       }
      }
      
      
/*
        Output Format ----
        
        x * 1 = x
        x * 2 = 2x
        ..
        x * 4 = 10x
        
        
        Output -----
        
        3 * 1 = 3
        3 * 2 = 6
        3 * 3 = 9
        3 * 4 = 12
        3 * 5 = 15
        3 * 6 = 18
        3 * 7 = 21
        3 * 8 = 24
        3 * 9 = 27
        3 * 10 = 30
*/      