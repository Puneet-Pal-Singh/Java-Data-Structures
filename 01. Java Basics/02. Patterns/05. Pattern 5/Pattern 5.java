import java.util.*;

public class Main{
            
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            
            // write ur code here
            int nrows = scn.nextInt();  // Always Odd 7
                 
            int nstars = 1;
            int nspace = nrows/2; //7/2 = 3
                 
            for(int crows = 1; crows <= nrows; crows++) //
            {
                for(int cspace = 1; cspace <= nspace; cspace++)
                {
                    System.out.print("\t");
                }
                for(int cstars = 1; cstars <= nstars; cstars++)
                {
                    System.out.print("*\t");
                }
                    
                if(crows <= nrows/2)
                {
                    nspace--;
                    nstars += 2;
                }
                else
                {
                    nspace++;
                    nstars -= 2;
                }    
                System.out.println(); // Moving in every row
            }
        }
}

//      _   _   *           -- // space = 2  star = 1
//      _   *   *   *       -- // space = 1  star = 3
//      *   *   *   *   *   -- // space = 0  star = 5
//      _   *   *   *       -- // space = 1  star = 3
//      _   _   *           -- // space = 2  star = 1



/*		

                	*	
        	*	*	*	
        *	*	*	*	*	
        	*	*	*	
        		*	
		
		
*/