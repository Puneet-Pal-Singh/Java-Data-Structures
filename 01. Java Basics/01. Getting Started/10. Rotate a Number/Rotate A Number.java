import java.util.*;
   
public class Main{
   
    public static void main(String[] args) {
     // write your code here  
        Scanner sc = new Scanner(System.in);
     
         int n = sc.nextInt(); //28765
         int k = sc.nextInt(); //23
         
         int length = 0;
         int temp = n;
         
         while( temp > 0)
         {
            length++; //5 
            temp =temp/10; 
         }
         k = k % length; //23/5=3   
         if( k < 0)
         {
            k = k + length;
         }
         
         int div = 1 ; int mul = 1;
         for( int i = 1; i <= length ; i++) // 1 2 3 4 5 6 
         {
            if(i <= k)
            {
                div = div * 10; //1 10 100 1000
            }
            else
            {
                    mul = mul * 10; // 1 10 100
            }
            
         }
         
         int p1 = n / div;  // 28765/1000=28
         int p2 = n % div;  // 28765%1000=765
         int ans = (p2 * mul) + p1; //76500 + 28 = 76528 
         System.out.println(ans); 
         
         
    }
}

/*
        Sample Input
        
        562984
        2
        
        Sample Output
        
        845629

*/