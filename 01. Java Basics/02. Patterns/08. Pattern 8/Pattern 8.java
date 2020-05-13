import java.util.*;
     
     public class Main{
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
        //  ()
         int nrows = scn.nextInt();
         
         for(int crows = 1; crows <= nrows; crows++)
         {
             for(int c_col = 1; c_col <= nrows; c_col++){
                if(c_col + crows == nrows + 1){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
             }
             System.out.println();
         }
      }
     }
     
/*
        Output ----
        						*	
        					*		
        				*			
        			*				
        		*					
        	*						
        *							
        

*/     