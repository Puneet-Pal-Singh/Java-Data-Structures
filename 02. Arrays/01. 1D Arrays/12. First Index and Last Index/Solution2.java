import java.io.*;
import java.util.*;

public class Main{
    
    public static int firstIndex( int arr[], int data){
        int low = 0;
        int high = arr.length - 1;
        int fi = -1;
        
        while( low <= high ){
            int mid = (low+high) /2;
            
            if(data > arr[mid]){
                low = mid + 1;
                
            }else if(data < arr[mid]){
                high = mid - 1;
                
            }else{
                fi = mid
                high = mid - 1;
                break;
            }
        }
        System.out.println( fi );
    }
        
    public static int lastIndex( int arr[], int data){
        int low = 0;
        int high = arr.length - 1;
        int li = -1;
        
        while( low <= high ){
            int mid = (low+high) /2;
            
            if(data > arr[mid]){
                low = mid + 1;
                
            }else if(data < arr[mid]){
                high = mid - 1;
                
            }else{
                li = mid
                low = mid + 1;
                break;
            }
        }
        System.out.println( li );
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
        
        firstIndex( arr, data);
        lastIndex( arr, data);
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
