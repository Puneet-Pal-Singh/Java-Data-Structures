import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }
    
    static class pair implements Comparable<pair>{
        int st;
        int et;
        pair( int s, int e ){
            st = s; et = e;
        }
        public int compareTo( pair other ){
            return this.st - other.st;
        }
    }
    
    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
    
        pair[] intervals = new pair[arr.length];
        for( int i = 0 ; i < arr.length ; i++ ){
            pair cp = new pair( arr[i][0], arr[i][1] );
            intervals[i] = cp;
        }
        
        Arrays.sort( intervals );
        Stack<pair> st = new Stack<>();
        st.push( intervals[0] );
        
        for( int i = 1; i < arr.length ; i++ ){
            pair cp = intervals[i];
            if( cp.st <= st.peek().et ){
                st.peek().et = Math.max( st.peek().et, cp.et );
            }else{
                st.push( cp );
            }
        }
        
        Stack<pair> opst = new Stack<>();
        while( st.size() > 0 ){
            opst.push( st.pop() );
        }
        while( opst.size() > 0 ){
            pair cp = opst.pop();
            System.out.println( cp.st + " " + cp.et );
        }
    }
}

/*
        Sample Input
        6
        22 28
        1 8
        25 27
        14 19
        27 30
        5 12
        
        Sample Output
        1 12
        14 19
        22 30

*/