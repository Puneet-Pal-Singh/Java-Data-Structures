import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
         // write ur code here
            int nrows = scn.nextInt();  // Always Odd 7
                     
            int nstars = nrows;
            int nspace = 0; //7/2 = 3
                     
            for(int crows = 1; crows <= nrows; crows++) //
            {
                for(int cspace = 1; cspace <= nspace; cspace++){
                   System.out.print("\t");
                }
                for(int cstars = 1; cstars <= nstars; cstars++){
                    
                    //upper half other than first row && leave 1st and last star
                    
                    if(crows != 1 && crows <= nrows/2 && cstars != 1 && cstars != nstars){
                        System.out.print("\t");
                    }else{
                        System.out.print("*\t");
                    }
                }
                
                if(crows <= nrows/2){
                    nstars -= 2;        nspace++;
                }else{
                    nstars += 2;          nspace--;
                }        
                System.out.println(); // Moving in every row
            }
                    
    
     }
}

/*

    ---Step - 1
       
        *   *   *   *   *   *   *
            *   *   *   *   *       
                *   *   *
                    *
                *   *   *
            *   *   *   *   *       
        *   *   *   *   *   *   *
        
    Final -- Output    
        
        *	*	*	*	*	*	*	
        	*				*	
        		*		*	
        			*	
        		*	*	*	
        	*	*	*	*	*	
        *	*	*	*	*	*	*	


*/