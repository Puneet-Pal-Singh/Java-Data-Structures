import java.util.*;
  
public class Main{
  
      public static void main(String[] args) {
          // write your code here
          Scanner sc = new Scanner(System.in);
          
          int n = sc.nextInt();
          int a = 0;
          int b = 1;
          while(n > 0)
          {
              System.out.println(a);
              int c = a +b;
              a = b;
              b = c;
              n--;
          }
         
         
       }
}


/*
        Sample Input
        
        10
        
        Sample Output
        
        0
        1
        1
        2
        3
        5
        8
        13
        31
        34
*/