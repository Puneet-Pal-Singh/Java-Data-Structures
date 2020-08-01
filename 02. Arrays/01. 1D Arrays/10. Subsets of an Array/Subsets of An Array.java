import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
           arr[i] = scn.nextInt();
        }
        
        int limit = (int)Math.pow(2, arr.length);       // as there are 2^n Subsets  
        
        // Convert i to binary and use 0's and 1's
        for(int i = 0; i < limit; i++){
           
            int temp = i; 
            
            // First Storing it in a string rather than direct printing
            String str = "";
    
            for(int j = arr.length - 1; j >= 0; j--){
                int rem = temp % 2;
                temp = temp / 2;
    
                if(rem == 0){
                    str = "-\t" + str;
                } else {
                    str = arr[j] + "\t" + str;
                }
            }
            System.out.println(str);
        }
    }
}