import java.util.*;
            
public class Main{
            
        public static void main(String[] args) {
                Scanner scn = new Scanner(System.in);
            
                 // write ur code here
                 int nrows = scn.nextInt();  // Always Odd 7
                 
                 int nstars = 1;
                 int nspace = nrows/2; //7/2 = 3
                 /*
                 for(int crows = 1; crows <= nrows; crows++) //
                 {
                    for(int cspace = 1; cspace <= nspace; cspace++)
                    {
                         if(crows == (nrows/2) + 1)
                        {
                            System.out.print("*\t");
                        }
                        else
                        {
                            System.out.print("\t");
                        }
                        
                    }
                    for(int cstars = 1; cstars <= nstars; cstars++)
                    {
                        System.out.print("*\t");
                        
                    }
                    
                    
                    if(crows <= nrows/2)
                    {
                        // nspace--;
                        nstars ++;
                    }
                    else
                    {
                        // nspace++;
                        nstars --;
                    }        
                    System.out.println(); // Moving in every row
                 }
                 */
                 
                //  Second Way diamond 
                
                for(int crows = 1; crows <= nrows; crows++) //
                 {
                    for(int cspace = 1; cspace <= nspace; cspace++)
                    {
                        System.out.print("\t");
                    }
                    for(int cstars = 1; cstars <= nstars; cstars++) //1<1 , 1<3
                    {
                        if(cstars <= nstars/2 && crows != (nrows/2) + 1)  // 1<=0 F *, 1<=1 & 2!=3 T,  
                        {
                            System.out.print("\t");
                        }
                        else
                        {
                            System.out.print("*\t");
                        }
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
//      _   _   *   *       -- // space = 2  star = 2
//      *   *   *   *   *   -- // space = 0  star = 5
//      _   _   *   *       -- // space = 1  star = 3
//      _   _   *           -- // space = 2  star = 1



/*	
        
                	*	
        		*	*	
        *	*	*	*	*	
        		*	*	
        		*	
		
		
*/