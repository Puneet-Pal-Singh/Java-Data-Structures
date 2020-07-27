import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        // Array 1
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = scn.nextInt();
        }
        
        // Array 2
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = scn.nextInt();
        }

        int[] sum = new int[n1 > n2? n1: n2];
        int carry = 0;

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sum.length - 1;

        while (k >= 0) {
            int digit = carry;

            if (i >= 0) {
                digit += arr1[i];
            }

            if (j >= 0) {
                digit += arr2[j];
            }

            carry = digit / 10;
            digit = digit % 10;

            sum[k] = digit;

            i--;
            j--;
            k--;
        }

        if (carry > 0) {
            System.out.println(carry);
        }

        for (int val : sum) {
            System.out.println(val);
        }
    }
}
