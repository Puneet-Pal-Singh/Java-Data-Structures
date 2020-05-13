import java.util.*;
            
public class Main{
            
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
            
        // write ur code here
        int nrows = scn.nextInt();  
        int nstars = 1;
        int nspace = nrows - 1;
                 
        for(int crows = 1; crows <= nrows; crows++)
        {
            for(int cspace = 1; cspace <= nspace; cspace++)
            {
                System.out.print("\t");
            }
            for(int cstars = 1; cstars <= nstars; cstars++)
            {
                System.out.print("*\t");
            }
             
            nspace--;    nstars++;
            System.out.println();
        }
            
    }
}
            
            
//         *   --
//       * *   --
//     * * *   --
//   * * * *   --
// * * * * *   --  


/*  Output
    
    
        				*	
        			*	*	
        		*	*	*	
        	*	*	*	*	
        *	*	*	*	*     

*/	

            