import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();
        
        int index = -1;
        for(int i = 0; i < n; i++){
            if(arr[i] == data){
                index = i;
                break;
            }
        }
        System.out.println(index);
    }

}

/*
        Sample Input
        6
        15
        30
        40
        4
        11
        9
        40
        
        Sample Output
        2

*/