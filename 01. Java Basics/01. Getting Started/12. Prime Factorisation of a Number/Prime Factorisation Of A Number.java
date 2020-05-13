import java.util.*;

public class Main{
    public static void main(String[] args)
    
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int div = 2; //3
        
        while( div * div <= n) // 2*2= 4 ,3*3 = 9
        {
            if(n % div == 0) 
            {
                System.out.print(div + " "); //  2 2 2 2 2 3 3 5
                n = n / div;  // 1440/2 = 720/2 = 360/2 = 180/2 = 90/2 = 45/3 = 5
            }
            else
            {
                div++; //2 3
            }
        }
        
        if(n != 1)
        {
            System.out.print(n);  //5
        }
        
        
    }    
}



/*
        Sample Input
        
        1440
        
        Sample Output
        
        2  2  2  2  2  3  3  5
*/