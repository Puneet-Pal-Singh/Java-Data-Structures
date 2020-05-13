import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      // write your code here
     
      int ans = 0;
      int pow = 1;
      
      while(n > 0){
          int rem = n % 10;
          n = n / 10; 
          
          ans = ans + rem * pow;   
          pow = pow * b;
      }
      return ans;
   }
  }
  
/*
        Input ---
        
        - 111001
        - 2
        
        Output ---
        
        - 57
  
  
*/