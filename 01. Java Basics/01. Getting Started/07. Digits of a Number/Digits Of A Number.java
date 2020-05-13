import java.util.*;

public class Main{
    
    public static void main(String[] args) {
          // write your code here 
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
        
        //   Calculating digits
          int temp = n; //12345 //making a copy
          int digits = 0; //1  2  3  4
          
          while(temp > 0)
          {   
              temp = temp / 10;  //1234 123 12 1 0
              digits++;
          }
          
        //   
          int pow = 1;    //10 100 1000 10000
          
          while(digits > 1) //4 3 2 1
          {
              pow = pow * 10;
              digits--;   //4 3 2 1
          }
          
          temp = n; //as temp is 0 we are setting it to n - 1234
          
          while (pow > 0)
          {
            int d  = temp / pow; // 2345/1000  345/100  45/10  5/1 0
            System.out.println(d); // 1 2 3 4
            temp = temp % pow; //2345/1000  345/100  45/10  5/1 0    
            pow = pow/10; // 1000 100 10 1
          }
    }
        
}

/*
        Sample Input
        
        65784383
        
        Sample Output
        
        6
        5
        7
        8
        4
        3
        8
3
*/
    