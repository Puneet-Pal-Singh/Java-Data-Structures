import java.io.*;
import java.util.*;

public class Main{
    
    public static void findCAF(int[] arr, int data){
        if(data < arr[0]){
            System.out.println(arr[0]);
            System.out.println(-1);
            return;    
        }else if( data > arr[ arr.length - 1] ){
            System.out.println(-1);
            System.out.println( arr[ arr.length - 1] ); 
            return;    
        }
        int low = 0;
        int high = arr.length-1;
        
        while( low<=high ){
            int mid = (low+high) /2;
            
            if(arr[mid] == data){
                System.out.println(data); //ceil
                System.out.println(data); //floor
                return;
            }else if(arr[mid] < data){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        System.out.println( arr[low] ); //ceil
        System.out.println( arr[high] ); //floor
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        findCAF(arr , data);
    }
}

/*
        Sample Input
        10
        1
        5
        10
        15
        22
        33
        40
        42
        55
        66
        34
        
        Sample Output
        40
        33
*/