import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        // write your code here

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    gcc(arr, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    
    public static void gcc(int[][] arr, int i, int j) {
        
        arr[i][j] = 1;
        if (j - 1 >= 0 && arr[i][j - 1] == 0){
            gcc(arr, i, j - 1);
        }
        if (j + 1 < arr[0].length && arr[i][j + 1] == 0){
            gcc(arr, i, j + 1);
        }
        if (i - 1 >= 0 && arr[i - 1][j] == 0){
            gcc(arr, i - 1, j);
        }
        if (i + 1 < arr.length && arr[i + 1][j] == 0){
            gcc(arr, i + 1, j);
        }
    }
}

/*
        Sample Input
        
        8
        8
        0 0 1 1 1 1 1 1
        0 0 1 1 1 1 1 1
        1 1 1 1 1 1 1 0
        1 1 0 0 0 1 1 0
        1 1 1 1 0 1 1 0
        1 1 1 1 0 1 1 0
        1 1 1 1 1 1 1 0
        1 1 1 1 1 1 1 0
        
        Sample Output
        
        3
*/