import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception 
    {
       Scanner scr=new Scanner(System.in);
       int n1=scr.nextInt();
       int m1=scr.nextInt();
       int [][] a=new int [n1][m1];
       for(int i=0;i<n1;i++)  //i<a.length
       {
           for(int j=0;j<m1;j++)  //j<a[0].length
           {
             a[i][j] =scr.nextInt();  
           }
       }
       int n2=scr.nextInt();
       int m2=scr.nextInt();
       int [][] b=new int [n2][m2];
       for(int i=0;i<n2;i++)  //i<b.length
       {
           for(int j=0;j<m2;j++)  //j<b[0].length
           {
             b[i][j] =scr.nextInt();  
           }
       }
       
       if(m1 != n2)
       {
           System.out.println("Invalid input");
           return;
       }
        int [][] prd=new int [n1][m2];
       for(int i=0;i<n1;i++)  
       {
           for(int j=0;j<m2;j++)
           {
               for(int k=0;k<b.length;k++)
               {
                  prd[i][j] +=a[i][k]*b[k][j];  
               }
           }
       }
        
        for(int i=0;i<prd.length;i++)  
       {
           for(int j=0;j<prd[0].length;j++)
           {
             System.out.print(prd[i][j]+" ");   
           }
           System.out.println();
       }
    }
    
}


/*

        Sample Input
        2
        3
        10 0 0 
        0 20 0
        
        3 
        4
        1 0 1 0
        0 1 1 2
        1 1 0 0
        
        Sample Output
        
        10 0 10 0
        0 20 20 40
*/