import java.io.*;
import java.util.*;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] chess=new int[n][n];
        printKnightsTour(chess,r,c,1);
        System.out.println();
    }
    public static void printKnightsTour(int[][] chess, int r, int c,int nextMove)
    {
        if(nextMove == chess.length*chess[0].length)
        {
            chess[r][c]=nextMove;
            displayBoard(chess);
            chess[r][c]=0;
            return;
        }
        chess[r][c]=nextMove;
        if(r-2>=0 && c+1<chess[0].length && chess[r-2][c+1]==0){
            printKnightsTour(chess, r - 2, c + 1 , nextMove + 1);
        }
        if(r-1>=0 && c+2<chess[0].length && chess[r-1][c+2]==0){
            printKnightsTour(chess, r - 1, c + 2 , nextMove + 1);
        }
        if(r+1<chess.length && c+2<chess[0].length && chess[r+1][c+2]==0){
            printKnightsTour(chess, r + 1, c + 2 , nextMove + 1);
        }
        if(r+2<chess.length && c+1<chess[0].length && chess[r+2][c+1]==0){
            printKnightsTour(chess, r + 2, c + 1 , nextMove + 1);
        }
        if(r+2<chess.length && c-1>=0 && chess[r+2][c-1]==0){
            printKnightsTour(chess, r + 2, c - 1 , nextMove + 1);
        }
        if(r+1<chess.length && c-2>=0 && chess[r+1][c-2]==0){
            printKnightsTour(chess, r + 1, c - 2 , nextMove + 1);
        }
        if(r-1>=0 && c-2>=0 && chess[r-1][c-2]==0){
            printKnightsTour(chess, r - 1, c - 2 , nextMove + 1);
        }
        if(r-2>=0 && c-1>=0 && chess[r-2][c-1]==0){
            printKnightsTour(chess, r - 2, c - 1 , nextMove + 1);
        }
        chess[r][c]=0;
    }
    public static void displayBoard(int[][] chess)
    {
        for(int i = 0; i < chess.length; i++)
        {
            for(int j = 0; j < chess[0].length; j++)
            {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}



/*
        Input---
        
        5
        2
        2
        
        Output---
        
        21 12 7 2 19 
        6 17 20 13 8 
        11 22 1 18 3 
        16 5 24 9 14 
        23 10 15 4 25 
        
        23 12 7 2 25 
        6 17 24 13 8 
        11 22 1 18 3 
        16 5 20 9 14 
        21 10 15 4 19 
        
        .
        .
        .
        so on

*/