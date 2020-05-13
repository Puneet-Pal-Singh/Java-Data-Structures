import java.util.*;
      
      public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int nrows = scn.nextInt();  //5
           
           for(int crows = 1; crows <= nrows; crows++) //5
           {
                for(int c_col = 1; c_col <= nrows; c_col++) //5
                { 
                    if(crows == c_col || crows + c_col == nrows + 1)  
                    {
                        System.out.print("*\t");
                    }
                    else
                    {
                        System.out.print("\t");
                    }
                }
                
                System.out.println();
           }
      }
      }

/*
   Assuming this as matrix
   rows and columns are same in this format - \
   rowa + columns = 6        in this format - /
   // 1 = 1 ||       true   ,1 = 2 ||   false     , 1 = 3 false ||   , 1 = 4 false  , 1 = 5 true   
   // 2 = 1 || 6     false  ,2 = 2 || 6 true      , 1 = 3 false ||   , 1 = 4 true   , 1 = 5||6 false  
   // 3 = 1 ||       false  ,3 = 2 ||   false     , 3 = 3 true  ||   , 3 = 4 false  , 3 = 5 false   
   // 4 = 1 ||       false  ,4 = 2 ||   true      , 4 = 3 false ||   , 4 = 4 true   , 4 = 5 false
   // 5 = 1 || 6 = 6 true   ,5 = 2 ||   false     , 5 = 3 false ||   , 5 = 4 false  , 5 = 5 true   
*/


/*      
        *				*	
        	*		*		
        		*			
        	*		*		
        *				*	
*/