import java.util.*;
      
public class Main{
      
      public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
      
           // write ur code here
           int nrows = scn.nextInt(); // 4
           int nspaces = 0;
           int nstars = nrows;
          
           for(int crows =1; crows <= nrows; crows++) //1<4  2
           {   
               for(int cspaces = 1; cspaces <= nspaces; cspaces++)
               {
                    System.out.print("\t");
               }
               
               for(int cstars = 1; cstars <= nstars; cstars++) //1<=4 2<=4 3<=4 4<=4 
               {
                   System.out.print("*\t");
               }
               
               
               nspaces++;
               nstars--;
               
               System.out.println();
           }
       }
}
      
      
/*

        Output --
        
		*	*	*	*	*	*	*	*	
			*	*	*	*	*	*	*	
				*	*	*	*	*	*	
					*	*	*	*	*	
						*	*	*	*	
							*	*	*	
								*	*	
									*	
    

*/     