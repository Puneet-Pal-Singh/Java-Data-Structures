import java.util.*;
     
public class Main{
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int nrows = scn.nextInt();
         
         int a = 0, b = 1; 
         int nstars = 1; // 2 3 4
         for(int crows = 1; crows <= nrows; crows++){
            for(int cstars = 1; cstars <= nstars; cstars++){
             System.out.print(a + "\t");
             int c = a + b;
             a = b;
             b = c;
            }
             
             nstars++; // 1 2 3 4
             System.out.println();
         }
     
      }
}
     
     
/*      Output
        
        0	
        1	1	
        2	3	5	
        8	13	21	34	
        55	89	144	233	377	
*/