import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        
        boolean[][] v = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scn.nextInt();
            }
        } // inputs handled
        
        floodfill(a, 0, 0, "", v);
        System.out.println();
    }
    
    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] v) {
       
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(psf);
            return;
        } //printing condition
        
        v[row][col] = true;
        
        // move UP
        if (row > 0 && maze[row - 1][col] != 1 && v[row - 1][col] == false) {
            floodfill(maze, row - 1, col, psf + "t", v);
        } 
        
        
        // move LEFT
        if (col > 0 && maze[row][col - 1] != 1 && v[row][col - 1] == false) {
            floodfill(maze, row, col - 1, psf + "l", v);
        } 
        
        
        //move DOWN
        if (row + 1 < maze.length && maze[row + 1][col] != 1 && v[row + 1][col] == false) {
            floodfill(maze, row + 1, col, psf + "d", v);
        } 
        
        
        //move RIGHT
        if (col + 1 < maze[0].length && maze[row][col + 1] != 1 && v[row][col + 1] == false) {
            floodfill(maze, row, col + 1, psf + "r", v);
        } 
        
        v[row][col] = false;
    }
}


/*
        
        Sample Input
        
        8
        8
        0 1 0 0 0 0 0 0
        0 1 0 1 1 1 1 0
        0 1 0 1 0 0 0 0
        0 1 0 1 0 1 1 1
        0 0 0 0 0 0 0 0
        0 1 0 1 1 1 1 0
        0 1 0 1 1 1 1 0
        0 1 0 0 0 0 0 0
        
        Sample Output
        
        ddddrrttttrrrrrddlllddrrrddd
        ddddrrdddrrrrr
        ddddrrrrrrrddd

*/