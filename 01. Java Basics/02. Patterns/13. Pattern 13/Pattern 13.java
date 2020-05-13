import java.util.*;
     
public class Main{
     
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         
         int nrows = scn.nextInt();
         
         // int nstars = 1;
         // n represents current row
         for(int n = 0; n < nrows; n++){
             
            int ncr = 1;
            // for(int r = 0; r <= nstars; r++){
            
            for(int r = 0; r <= n; r++){
                System.out.print(ncr + "\t");
                int ncrpo = ((n-r)*(ncr))/(r+1);
                ncr = ncrpo;
            }
            // nstars++;
            System.out.println();
     }
    }
}


/*      Output
        1	
        1	1	
        1	2	1	
        1	3	3	1	
        1	4	6	4	1	
        1	5	10	10	5	1	
        1	6	15	20	15	6	1	
        1	7	21	35	35	21	7	1	
        1	8	28	56	70	56	28	8	1	
*/