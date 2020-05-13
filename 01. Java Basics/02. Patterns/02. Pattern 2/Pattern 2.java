import java.util.*;
      
public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int nor = scn.nextInt(); // 4
           int nost = nor;
           
           for(int cr =1; cr <=nor; cr++) //1 2
           {
               for(int cst = 1; cst <= nost; cst++) //1<=4 2<=4 3<=4 4<=4 
               {
                   System.out.print("*\t");
               }
               nost--;
               System.out.println();
           }
      
       }
}
      
      
      // * * * *  1st row  ,nost = 4, cr = 1, 1<=4 2<=4 3<=4 4<=4
      // * * *    2nd row  ,nost = 3, cr = 2, 1<=4 2<=4 3<=4
      // * *      3rd row  ,nost = 2, cr = 3, 1<=4 2<=4
      // *       4th row  ,nost = 1, cr = 3, 1<=4 2<=4
      
      
      
/*      Output
      
        *	*	*	*	*	
        *	*	*	*	
        *	*	*	
        *	*	
        *	                     
        
*/