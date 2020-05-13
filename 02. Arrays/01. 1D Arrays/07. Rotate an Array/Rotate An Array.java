import java.io.*;
import java.util.*;

public class Main{
      
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + " ");
        }
        System.out.println(sb);
    }
        
    public static void reverse(int[] a, int i, int j){
        while( i < j ){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++; j--;
        }
    }    
        
    public static void rotate(int[] a, int k){
        // write your code here
        
        // making it in range for handling cases like lesss than or equal to 0
        k = k % a.length;
        if( k < 0 ){
            k = k + a.length;
        } 
        reverse( a , a.length - k , a.length - 1);
        reverse( a , 0 , a.length - k - 1);
        reverse( a , 0, a.length - 1);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
    
        rotate(a, k);
        display(a);
    }

}




/*
 
        Input ---
        
        5
        1
        2
        3
        4
        5
        2
        
        Output ---
        
        4 5 1 2 3 
    
*/