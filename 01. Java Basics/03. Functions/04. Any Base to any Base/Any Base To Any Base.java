import java.util.*;
  
public class Main{
  
    public static int anyBaseToDecimal(int n, int b){
        int ans = 0;    int pow = 1;
        while(n > 0){
          int rem = n % 10;
          n = n / 10; 
          ans = ans + rem * pow;   
          pow = pow * b;
      }
      return ans;
    }
    public static int decimalToAnyBase(int n, int b){
        int ans = 0;    int pow = 1;
        while(n > 0){
          int rem = n % b;
          n = n / b; 
          ans = ans + rem * pow;
          pow = pow * 10;
      }
      return ans;
    }
 
    public static int anyBaseToAnyBase(int n, int sb, int db){

      int deciNum = anyBaseToDecimal( n , sb);
      int destNum = decimalToAnyBase( deciNum, db);
      
      return destNum;
   } 
    
    public static void main(String[] args){
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sb = scn.nextInt(); // Source Base
      int db = scn.nextInt(); // destination Base
      int ans = anyBaseToAnyBase(n, sb, db);
      System.out.println(ans);
   }
   
}
  
/*
    Input--
    - 111001
    - 2
    - 3
    
    Output--
    -2010

*/