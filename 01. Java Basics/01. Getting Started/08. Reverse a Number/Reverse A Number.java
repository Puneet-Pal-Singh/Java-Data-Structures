import java.util.*;
   
public class Main{
   
   public static void main(String[] args) {
       
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
     
         while ( n > 0)
         {
            int digit = n % 10;
            n = n / 10;
         
         System.out.println(digit);
         }
    }
}

/*
        Sample Input
        
        65784383
        
        Sample Output
        
        3
        8
        3
        4
        8
        7
        5
        6
*/