import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
    
        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }
    
    public static int getProduct(int b, int n1, int n2){
        int ans = 0;
        int carry = 0;
        int pow = 1;
        while(n2 > 0){
            int d2 = n2 % 10;
            n2 = n2 / 10;
    
            int prod = getProductWithDigit(b, n1, d2);
            ans = getSum(b, ans, pow * prod);
            pow = pow * 10;
        }
        return ans;
    }

    public static int getProductWithDigit(int b, int n1, int d2){
        
        int ans = 0;
        int carry = 0;
        int pow = 1;
        while(n1 > 0 || carry > 0){
        int d1 = n1 % 10;
        n1 = n1 / 10;
    
        int num = d1 * d2 + carry;
        carry = num / b;
        num = num % b;
    
        ans += num * pow;
        pow = pow * 10;
        }
        return ans;
    }

    public static int getSum(int b, int n1, int n2){
        
        int ans = 0;
        int carry = 0;
        int pow = 1;
        while(n1 > 0 || n2 > 0 || carry > 0){
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;
            
            int num = d1 + d2 + carry;
            carry = num / b;
            num = num % b;
    
            ans += num * pow;
            pow = pow * 10;
        }
        return ans;
    }

}


/*
        Input---
        
        5
        1220
        31
        
        Output--
        
        43320
*/