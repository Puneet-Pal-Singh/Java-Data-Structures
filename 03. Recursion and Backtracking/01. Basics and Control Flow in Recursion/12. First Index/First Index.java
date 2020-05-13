import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scr= new Scanner(System.in);
       int n=scr.nextInt();
       int[] arr=new int[n];;
       
       for(int i=0;i<n;i++)
         arr[i]=scr.nextInt();
         
       int x=scr.nextInt();
       
       int firstval=firstIndex(arr,0,x);
       System.out.print(firstval);
    }

    public static int firstIndex(int[] arr, int idx, int x){
        
        if(idx == arr.length-1){  return -1;}
        
        if( arr[idx] == x )
        {
          return idx; 
        }
        
        int fo=firstIndex(arr,idx+1,x);

        // if( arr[idx] == x )
        // {
        //   return idx;  // fo=idx;
        // }
         return fo;
    }

}

/*
        Sample Input--
        
        6
        15
        11
        40
        4
        4
        9
        4
        
        Sample Output---
        
        3
*/