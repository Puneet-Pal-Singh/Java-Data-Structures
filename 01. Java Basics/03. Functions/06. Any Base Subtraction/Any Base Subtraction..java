import java.util.*;
  
public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt(); //
      int n1 = scn.nextInt(); // 
      int n2 = scn.nextInt(); //
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
                                    //8   // 326  //277
   public static int getDifference(int b, int n1, int n2){
       // write your code here
       
       int ans = 0;          //
       int pow = 1;          //
       int borrow = 0;       //1
       
            
       while(n2 > 0){
           int d1 = n1 % 10;        //last digit of n1 -- 7 7 2
           int d2 = n2 % 10;        // last digit of n2 -- 6 2 3
           n1 = n1 / 10;            //  32
           n2 = n2 / 10;            // 27 
           
           d2 = d2 - borrow; //6, 2, 3-1=2
           borrow = 0;
           if(d2 < d1){
               d2 = d2 + b; //6+8=14 , 1+8=9 
               borrow = 1; //
           }
           ans = ans + (d2 - d1) * pow;        //(14-7)*1 = 7 , 7 + 2(9-7) =27, 27+200=227
           pow = pow * 10;                      //10 100 1000
       }
       return ans;
   }
}


/*
        Input--
        - 8
        - 1
        - 100
        
        Output--
        - 77

*/  