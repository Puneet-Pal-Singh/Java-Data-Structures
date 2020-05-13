import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int nrows = scn.nextInt();
         
           for(int crows = 1; crows <= nrows; crows++)
           {
               for(int c_col = 1; c_col <= nrows; c_col++)
               {
                   if(c_col == 1 || c_col == nrows)
                   {
                       System.out.print("*	");
                   }
                   else if(crows > nrows / 2 && (crows == c_col || crows + c_col == nrows + 1))
                   {
                      System.out.print("*	");
                   }
                   else
                   {
                      System.out.print("	");
                   }
               }
            System.out.println();
           }
       }
      }
      
      
      
/*
    Output---
    
    *				*	
    *				*	
    *		 *		*	
    *	  *		*	*	
    *				*	

*/