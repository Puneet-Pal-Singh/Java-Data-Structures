import java.util.*;
            
    public class Main{
            
        public static void main(String[] args) {
                Scanner scn = new Scanner(System.in);
            
                 // write ur code here
                 int nrows = scn.nextInt();  // Given - Always Odd 7
                 
                 int nstars = (nrows / 2) + 1;
                 int nspace = 1; //7/2 = 3
                 
                 for(int crows = 1; crows <= nrows; crows++) //
                 {
                    for(int cstars = 1; cstars <= nstars; cstars++)
                    {
                        System.out.print("*\t");
                    }
                    for(int cspace = 1; cspace <= nspace; cspace++)
                    {
                        System.out.print("\t");
                    }
                    for(int cstars = 1; cstars <= nstars; cstars++)
                    {
                        System.out.print("*\t");
                    }
                    
                    // Predicted future means for other rows than 1
                    if(crows <= nrows/2)
                    {
                        nspace += 2;
                        nstars--;
                    }
                    else
                    {
                        nspace -= 2;
                        nstars++;
                    }    
                    System.out.println(); // Moving in every row
                 }
            
        }
    }

//      *   *   *   _   *   *   *     -- // space = 2  star = 1
//      *   *   _   _   _   *   *     -- // space = 1  star = 3
//      *   _   _   _   _   _   *     -- // space = 0  star = 5
//      *   *   _   _   _   *   *     -- // space = 1  star = 3
//      *   *   *   _   *   *   *     -- // space = 2  star = 1


/*
        Output
        *	*	*	*		*	*	*	*	
        *	*	*				*	*	*	
        *	*						*	*	
        *								*	
        *	*						*	*	
        *	*	*				*	*	*	
        *	*	*	*		*	*	*	*	
*/


