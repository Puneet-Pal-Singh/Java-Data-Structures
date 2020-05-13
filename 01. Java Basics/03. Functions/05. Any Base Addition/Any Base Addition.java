import java.util.*;
  
public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt(); //8
      int n1 = scn.nextInt(); //444
      int n2 = scn.nextInt(); //1
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
                            //8     //444   //1    
   public static int getSum(int b, int n1, int n2){
       // write ur code here
       int ans = 0;          //1000
       int pow = 1;         //10 100 1000
       int carry = 0;       //1
       
            //44
       while(n1 > 0 || n2 > 0 || carry > 0){
           int d1 = n1 % 10;        //last digit of n1 -- 4 
           int d2 = n2 % 10;        // last digit of n2 -- 1 0 0
           n1 = n1 / 10;            //  44 4 0
           n2 = n2 / 10;            // 1 / 10 = 0/10 = 0 
           
           int num = d1 + d2 + carry;           // 4+1+0 = 5 ,4+0+1=5,5
           carry = num / b;                     // 5/5=1 , 0 
           num = num % b;                       // 5%5=0 , 1 
           ans = ans + num * pow;               //0+0*1= 0 , 0+1*1000 = 1000
           pow = pow * 10;                      // 10 100 1000
       }
       return ans;
   }
}
  
  
/*
        Input---
        - 8
        - 777 
        - 1
        
        Output---
        - 1000
*/  