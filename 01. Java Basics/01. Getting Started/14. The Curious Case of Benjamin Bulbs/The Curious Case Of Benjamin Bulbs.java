import java.util.*;
  
  public class Main {
  
  	  public static void main(String[] args) {
  	  	  Scanner scn = new Scanner(System.in);
          int n = scn.nextInt();
          
          for(int i = 1; i * i <= n; i++) // i * i for perfect square
          {
              System.out.println(i * i); //printing perfect square  
          }
  	  }
  }
  
  //36
  
  
  //1 * 13    //13 * 1
  //2 * 18    //18 * 2
  //3 * 12    //12 * 3
  //4 * 9     //9  * 4
  
  
  // 6 * 6