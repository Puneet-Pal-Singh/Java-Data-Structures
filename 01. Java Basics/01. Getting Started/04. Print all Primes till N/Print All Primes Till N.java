import java.util.*;

public class Main{
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        
        while(a <= b)
        { 
            int div = 2;
            while(div*div <= a)
            {
                if(a % div == 0)
                {
                    break;
                }
                    div++;
            }
            
            if (div * div > a)
            {
                System.out.println(a);
            }
            a++;
        }
        
    }
}

/*
        Sample Input
        
        6 
        24
        
        Sample Output
        
        7
        11
        13
        17
        19
        23
*/