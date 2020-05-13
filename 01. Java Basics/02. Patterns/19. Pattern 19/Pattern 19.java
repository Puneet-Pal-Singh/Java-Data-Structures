import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        // write ur code here ---   ()
        
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if( i == 1 ) // First Row (1)
                {
                    if(j == n || j <= n/2 + 1) // last col , first half
                    {
                        System.out.print("*\t");
                    }
                    else
                    {
                        System.out.print("\t");       
                    }
                }
                else if(i <= n/2 ) // 7/2 <= (2,3) First Half except first row  
                {
                    if(j == n || j == n/2 + 1) // last col , center col
                    {
                        System.out.print("*\t");
                    }
                    else
                    {
                        System.out.print("\t");       
                    }
                }
                else if(i == n/2 + 1) // 7/2 = 3+1 = (4) center row
                {
                    System.out.print("*\t");
                }
                else if(i < n) // (5 , 6)  less than n but not from above
                {
                    if(j == 1 || j == n/2 + 1) // first col , center col
                    {
                        System.out.print("*\t");
                    }
                    else
                    {
                        System.out.print("\t");       
                    }
                }
                else // (7)
                {
                    if(j == 1 || j >= n/2 + 1) // first col , center col
                    {
                        System.out.print("*\t");
                    }
                    else
                    {
                        System.out.print("\t");      
                    }
                }
            }
            System.out.println();
        } 
     }
}


/*
        Output -----
        
    
        *	*	*	*			*	
        			*			*	
        			*			*	
        *	*	*	*	*	*	*	
        *			*				
        *			*				
        *			*	*	*	*	
        
*/