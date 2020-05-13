import java.util.*;
       
public class Main{
       
       public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
       
            // write ur code here
            int nor = scn.nextInt(); // number of row
            int nost = 1; //number of star ----  1 2
            
            for ( int cr = 0; cr < nor ; cr++)  // 1 2
            {
                for( int cst = 0; cst < nost ; cst++) //1 2 3false
                {
                    System.out.print("*\t");    
                }
                nost++; // future Prediction ---- 1 2 3 4 5
                System.out.println(); //moving in every row
            }
       
        }
}   
       
       
       
       
/*      Output
       
        *	
        *	*	
        *	*	*	
        *	*	*	*	
        *	*	*	*	*	
*/