import java.io.*;
import java.util.*;

public class Main{
    
    public static int firstIndex( int arr[], int data){
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high)/2;
            if( arr[mid] == data){
                
                if(mid > 0 && arr[mid - 1] == arr[mid]){
                    high = mid - 1;
                }else{
                    return mid;
                }
                
            }else if(arr[mid] < data){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
        
    public static int lastIndex( int arr[], int data){
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high)/2;
            if( arr[mid] == data){
                
                if(mid < arr.length-1 && arr[mid + 1] == arr[mid]){
                    low = mid + 1;
                }else{
                    return mid;
                }
                
            }else if(arr[mid] < data){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int [] arr = new int [n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        
        System.out.println( firstIndex( arr, data));
        System.out.println( lastIndex( arr, data));
    }

}
    
/*
        Sample Input
        
        15
        1 5 10 15 22 33 33 33 33 33 40 42 55 66 77 33
        
        Sample Output
        
        5
        9
*/    
