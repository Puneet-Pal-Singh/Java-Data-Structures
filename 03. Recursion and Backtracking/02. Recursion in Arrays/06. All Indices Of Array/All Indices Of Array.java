import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if (iarr.length == 0) {
            System.out.println();
            return;
        }

        for (int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int count) {
        // write ur code here

        if (idx == arr.length) {
            return new int[count];
        }

        if (arr[idx] == x) {
            int[] ans = allIndices(arr, x, idx + 1, count + 1);
            ans[count] = idx;
            return ans;
        } else {
            int[] ans = allIndices(arr, x, idx + 1, count);
            return ans;
        }

        /*
            if(idx == arr.length){
                int[] baseAns = new int[count];
                return baseAns;
            }
            
            // Pre part 
            if( arr[idx] == x ){
                count++;
            }
            
            int[] ans = allIndices( arr, x, idx + 1, count );
            
            // Post Part
            if( arr[idx] == x){
                ans[count - 1 ] = idx;
            }
            return ans;
        */

    }
}


/*
        Sample Input
        
        6
        15
        11
        40
        4
        4
        9
        4
        
        Sample Output
        
        3
        4

*/
