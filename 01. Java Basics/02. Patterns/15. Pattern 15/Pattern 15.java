import java.util.*;
            
public class Main{
            
    public static void main(String[] args) {
                Scanner scn = new Scanner(System.in);
            
                 // write ur code here
                 int nrows = scn.nextInt();  // Always Odd 7
                 
                 int nstars = 1;
                 int nspace = nrows/2; // 7/2 = 3
                
                 //  int outval = 1;
                 
                 for(int crows = 1; crows <= nrows; crows++) //
                 {  
                    // int val = outval; 
                    int val = 0;
                    
                    //for lower half decrement -- 5th step
                    if(crows <= nrows/2){
                        val = crows;
                    }else{
                        val = nrows - crows + 1;
                    }
                    
                    for(int cspace = 1; cspace <= nspace; cspace++)
                    {
                        System.out.print("\t");  //"\t -- backSlash t"
                    }
                    for(int cstars = 1; cstars <= nstars; cstars++)
                    {
                        
                        System.out.print(val + "\t"); //"\t -- backSlash t"
                        
                        //for upper half decrement--4th step
                        if(cstars <= nstars/2){
                            val++;
                        }else{
                            val--;
                        }
                        
                    }
                    
                    if(crows <= nrows/2)
                    {
                        nspace -= 1;
                        nstars += 2;
                        // outval++;
                    }
                    else
                    {
                        nspace += 1;
                        nstars -= 2;
                        // outval--;
                    }    
                    System.out.println(); // Moving in every row
                 }
            
    }
}
            
/*

     -------Step 1-------	

        	*	
	*	*	*	
*	*	*	*	*	
	*	*	*	
		*     

     -------Step 2-------
        	1	
	1	1	1	
1	1	1	1	1	
	1	1	1	
		1
		
     -------Step 3-------
        	1	
	2   	3	4	
3	4	5	6	7	
	4	5	6	
		5
		
     -------Step 4------

        	1	
	2	3	2	
3	4	5	4	3	
	4	5	4	
		5
		
     -------Step Final--------

        	1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1     	


*/       
            
            