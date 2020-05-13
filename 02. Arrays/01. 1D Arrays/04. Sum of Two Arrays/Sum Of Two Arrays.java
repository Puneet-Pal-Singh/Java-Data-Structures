import java.io.*;
import java.util.*;

public class Main{
    public static int[] addition(int[] a, int[] b){
        
        int length = a.length;
        if( length < b.length){
            length = b.length;
        }
        
        int[] ans = new int[length+1];
        
        int i = a.length - 1, j = b.length - 1, k = length, carry = 0;
        
        //for common part
        while(i >= 0 && j >= 0){
            int sum = a[i] + b[j] + carry;
            carry = sum / 10;
            ans[k] = sum % 10;
            i--; j--; k--;
        }
        
        //if arr1 > arr2 and arr2 is finished
        while(i >= 0){
            int sum = a[i] + carry;
            carry = sum / 10;
            ans[k] = sum % 10;
            i--; k--;
        }
        
        //if arr2 > arr1 and arr1 is finished
        while(j >= 0){
            int sum = b[j] + carry;
            carry = sum / 10;
            ans[k] = sum % 10;
            j--; k--;
        }
        
        //only carry remains
        if(carry >0){
            ans[k] = carry;
        }
        return ans;
    }
    // int[] took as this function returns an array
    

    public static void main(String[] args) throws Exception{
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int size1 = scn.nextInt();
        int[] a = new int[size1];
        
        for(int i = 0; i < size1; i++){
            a[i] = scn.nextInt();
        }
        
        int size2 = scn.nextInt();
        int[] b = new int[size2];
        
        for(int i = 0; i < size2; i++){
            b[i] = scn.nextInt();
        }
        
        int[] ans = addition(a,b);
        
        for(int i = 0; i < ans.length; i++){
            
            //At zero index value is zero
            if (i == 0 && ans[i] == 0){
                
            }else{
                System.out.println(ans[i]);
            }
        }
    }
}


/*
    Input---
    
    - size1- 4
    - arr1 - 9
             9
             9
             9
    - size2- 2
    - arr2 - 1
             1
    
    Output--- 
    
        1
        0
        0
        1
        0


*/