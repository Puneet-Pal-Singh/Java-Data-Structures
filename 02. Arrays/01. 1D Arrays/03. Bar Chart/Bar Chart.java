import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] values = new int[n];
        
        for(int i = 0; i < n; i++){
            values[i] = scn.nextInt();
        }
        int max = values[0];
        for(int i = 0; i < n; i++){
            if(max < values[i]){
                max = values[i];
            }
        }    
        for(int i = max; i >= 1; i--){
            
            for(int j = 0; j < n ; j++){
                if(values[j] >= max){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            max--;          
            
            System.out.println();
        }
        /*
        for(int floor = max; floor >= 1; floor--){          // max height for floor value where i == floor 
            
            for(int j = 0; j < n ; j++){                    // n or arr.length 
                if(values[j] >= floor){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            
            System.out.println();
        }
        */
            
     }
}

/*
    Input---
    - 5
    - 3 1 0 7 5
    
    Output---
    
    			*		
    			*		
    			*	*	
    			*	*	
    *			*	*	
    *			*	*	
    *	*		*	*	
    
*/
