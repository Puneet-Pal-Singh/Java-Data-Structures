import java.util.*;
            
public class Main{
            
        public static void main(String[] args) {
                Scanner scn = new Scanner(System.in);
            
                 // write ur code here
                 int nrows = scn.nextInt();  // Always Odd 7
                 
                 int nstars = 1;
                 int nspace = (2 * nrows) - 3; // 7/2 = 3
                
                 for(int crows = 1; crows <= nrows; crows++) //
                 {  
                    int val = 1;
                    for(int cstars = 1; cstars <= nstars; cstars++)
                    {   
                        System.out.print(val + "\t");
                        val++;
                    }    
                    
                    for(int cspace = 1; cspace <= nspace; cspace++)
                    {
                        System.out.print("\t");  //"\t -- backSlash t"
                        
                    }
                    
                    // for last case one extra is printing for handling this we decrese one star and one value
                    if(crows == nrows)
                    {
                        nstars--; 
                        val--;
                    }
                    for(int cstars = 1; cstars <= nstars; cstars++)
                    {
                        val--;
                        System.out.print(val +"\t");
                        
                    }   
                        
                    nstars++;
                    nspace -= 2;
                        
                        
                    System.out.println(); // Moving in every row
                 }
            
        }
}
            
            
/* 

   num = 7 in rows
   rows = 4
   2n-1
   now 2n - 3 
   for 2nd row -- stars + 1 , space + 2
                  
   
    -- Step 1
    
    *                       *
    *   *               *   *   
    *   *   *       *   *   *   
    *   *   *   *   *   *   *

    -- Step 2
    
    1                       1
    1   1               1   1   
    1   1   1       1   1   1   
    1   1   1   1   1   1   1

    -- Step 3
    
    1                       2
    1   2               3   4   
    1   2   3       4   5   6   
    1   2   3   4   4   5   6

    -- Step 4
    
    1                       1
    1   2               2   1   
    1   2   3       3   2   1   
    1   2   3   4   3   2   1

   Output ---nrows = 7
   
    1												1	
    1	2										2	1	
    1	2	3								3	2	1	
    1	2	3	4						4	3	2	1	
    1	2	3	4	5				5	4	3	2	1	
    1	2	3	4	5	6		6	5	4	3	2	1	
    1	2	3	4	5	6	7	6	5	4	3	2	1	

*/
