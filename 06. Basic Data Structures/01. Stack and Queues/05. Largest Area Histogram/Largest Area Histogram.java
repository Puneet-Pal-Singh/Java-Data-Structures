import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
           arr[i] = Integer.parseInt(br.readLine());
        }
    
        // code
        
        int[] sol = new int[n];
        int[] sor = new int[n];
        
        Stack<Integer> st = new Stack<>();
        for( int i = 0; i < n ; i++ ){
            while( st.size() > 0 && arr[ st.peek() ] >= arr[i] ){
                st.pop();
            }
            if( st.size() == 0 ){
                sol[i] = -1;
            }else{
                sol[i] = st.peek();
            }
            st.push( i );
        }
        st = new Stack<>();
        
        for( int i = n - 1; i >= 0 ; i-- ){
            while( st.size() > 0 && arr[ st.peek() ] >= arr[i] ){
                st.pop();
            }
            if( st.size() == 0 ){
                sor[i] = n;
            }else{
                sor[i] = st.peek();
            }
            st.push(i);
        }
        
        int maxArea = arr[0] * ( sor[0] - sol[0] - 1 );
        
        for( int i = 1; i < n ; i++ ){
            int height = arr[i];
            int width = sor[i] - sol[i] - 1;
            int currArea = height * width;
            if( maxArea < currArea ){
                maxArea = currArea;
            }
        }
        System.out.println(maxArea);
    }
}


/*
    Sample Input
    7
    6
    2
    5
    4
    5
    1
    6
    
    Sample Output
    12
    
*/