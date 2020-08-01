import java.io.*;
import java.util.*;

public class Main{
      public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
            System.out.println(val);
        //   sb.append(val + "\n");
        }
        // System.out.println(sb);
      }
    
      public static int[] inverse(int[] a){
        // write your code here
        int[] ans = new int[a.length];
    
        for(int i = 0; i < a.length; i++){
          int val = a[i];
          ans[val] = i;
        }
    
        return ans;
      }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
    
        int[] inv = inverse(a);
        display(inv);
     }

}


/*
        Input---
        
        5
        4
        0
        2
        3
        1
        
        Output---
        1
        4
        2
        3
        0
*/
