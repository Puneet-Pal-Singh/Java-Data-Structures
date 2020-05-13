import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
       // write ur code here
       int t = scn.nextInt();
       for ( int i = 0 ; i < t ; i++)
       {
           int n = scn.nextInt();
           if (n == 0 || n == 1)
           {
               System.out.println("not prime");
           }
           else
           {   int div = 2 ;
               while( div * div <= n)
               {
                   if (n % div == 0)
                   {
                     
                       break;
                   }
                   div++;
               }
               if ( div * div > n )
               {
                   System.out.println("prime");
               }
               else
               {
                  System.out.println("not prime");
               }
           }
       }
    }
}
  
  
/*
        Sample Input
        
        5
        19
        21
        33
        37
        121
        
        Sample Output
        
        prime
        not prime
        not prime
        prime
        not prime
*/  