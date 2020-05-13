import java.util.*;

public class Main{

    public static void main(String[] args) {
          // write your code here 
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          
          int cd = 1;
          int ans = 0;
           
          while(n > 0)
          {
              int d = n % 10;
              n = n /10;
              
              ans = ans + (cd * (int)(Math.pow(10,d-1)));
              cd++;
          }
          System.out.println(ans);
    }
}

/*
        Sample Input
        426135
        
        Sample Output
        416253
*/