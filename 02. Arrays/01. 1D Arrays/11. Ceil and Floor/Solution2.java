import java.io.*;
import java.util.*;

public class Main{
    
    public static void findCAF(int[] arr, int data){
        
        int low = 0;
        int high = arr.length-1;
        int ceil = 0;
        int floor = 0;
        
        while( low <= high ){
            int mid = (low+high) /2;
            
            if(data < arr[mid]){
                high = mid - 1;
                ceil = arr[mid];
            }else if(data > arr[mid]){
                low = mid + 1;
                floor = arr[mid];
            }else{
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }
        System.out.println( ceil );
        System.out.println( floor ); 
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
