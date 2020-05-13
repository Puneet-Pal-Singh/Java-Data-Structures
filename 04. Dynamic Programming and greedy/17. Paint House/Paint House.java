import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        
        int[][] cost = new int[3][n];
        
        // col represents house
        for( int col = 0 ; col < n ; col++ ){
            cost[0][col] = scn.nextInt(); // red
            cost[1][col] = scn.nextInt(); // blue
            cost[2][col] = scn.nextInt(); // green
        }
        
        int redCost = cost[0][0];
        int blueCost = cost[1][0];
        int greenCost = cost[2][0];
        
        for( int col = 1; col < n ; col++){
            int red = cost[0][col] + Math.min( blueCost, greenCost );
            int blue = cost[1][col] + Math.min( redCost, greenCost );
            int green = cost[2][col] + Math.min( redCost, blueCost );
        
            redCost = red;
            blueCost = blue;
            greenCost = green;
        }
        System.out.println( Math.min( redCost, Math.min( blueCost, greenCost ) ) );
        
    }
}

/*
        Input--
        4
        1 5 7
        5 8 4
        3 2 9
        1 2 4
        
        Output--
        8
*/