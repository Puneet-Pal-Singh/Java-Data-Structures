import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());
    int xpn = power(x, n);
    
    /*
    
    // Using Scanner
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();
    int n = scn.nextInt();
    int xpn = power(x, n);
    
    */
    
    System.out.println(xpn);
  }

  public static int power(int x, int n) {
    if(n == 0){
      return 1;
    }
    int xpnb2 = power(x, n / 2);      // x raise to power n/2
    int xpn = xpnb2 * xpnb2;          // x raise to power n 

    if(n % 2 == 1){
      xpn = xpn * x;
    }

    return xpn;
  }

}


/*
        Sample Input
    
        2
        5
    
        Sample Output
    
        32
*/
