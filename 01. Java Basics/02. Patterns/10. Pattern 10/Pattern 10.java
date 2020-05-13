import java.util.*;
            
public class Main{
            
    public static void main(String[] args) {
                Scanner scn = new Scanner(System.in);
            
                 // write ur code here
                 int nrows = scn.nextInt();  // Always Odd 7
                 
                 int insp = -1;
                 int outsp = nrows/2;
                 
                 
                 for(int crows = 1; crows <= nrows; crows++) 
                 {  
                    // System.out.print(outsp + "," + insp);
                    for(int cspace = 1; cspace <= outsp; cspace++)
                    {
                        System.out.print("\t");
                    }
                    
                        System.out.print("*\t");
                    
                    for(int cspace = 1; cspace <= insp; cspace++)
                    {
                        System.out.print("\t");
                    }
                    
                    // First Row and last row
                    if(crows > 1 && crows < nrows)
                    {
                        System.out.print("*\t");
                    }
                    
                    if(crows <= nrows/2)
                    {
                        outsp--;
                        insp += 2;
                    }
                    else
                    {
                        outsp++;
                        insp -= 2;
                    }    
                    System.out.println(); // Moving in every row
                 }
            
    }
}
            
            
/*
        Output ----
        
        			*	
        		*		*	
        	*				*	
        *						*	
        	*				*	
        		*		*	
        			*	
        

*/            