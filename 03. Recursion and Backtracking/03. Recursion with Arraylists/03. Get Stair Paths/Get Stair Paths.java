import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList < String > ans = getStairPaths(n);
        System.out.println(ans);
    }
    
    /*
        public static ArrayList<String> getStairPaths(int n) {
            if( n == 0 ){
                ArrayList<String> baseAns = new ArrayList<>();
                baseAns.add("");
                return baseAns;
            }
            
            ArrayList<String> myAns = new ArrayList<>();
            if(n - 1 >= 0){
                ArrayList<String> nm1 = getStairPaths(n - 1);
                for(int i = 0; i < nm1.size(); i++ ){
                    myAns.add( "1" + nm1.get(i) );
                }
            }
            if(n - 2 >= 0){
                ArrayList<String> nm2 = getStairPaths(n - 2);
                for(int i = 0; i < nm2.size(); i++ ){
                    myAns.add( "2" + nm2.get(i) );
                }
            }
            if(n - 3 >= 0){
                ArrayList<String> nm3 = getStairPaths(n - 3);
                for(int i = 0; i < nm3.size(); i++ ){
                    myAns.add( "3" + nm3.get(i) );
                }
            }
            
            return myAns;
        }

    */
    
    public static ArrayList < String > getStairPaths(int n) {
        if (n == 0) {
            ArrayList < String > baseAns = new ArrayList < > ();
            baseAns.add("");
            return baseAns;
        } else if (n < 0) {
            ArrayList < String > baseAns = new ArrayList < > ();
            // baseAns.add("");
            return baseAns;
        }

        ArrayList < String > paths1 = getStairPaths(n - 1);
        ArrayList < String > paths2 = getStairPaths(n - 2);
        ArrayList < String > paths3 = getStairPaths(n - 3);
        ArrayList < String > myAns = new ArrayList < > ();


        // for(int i = 0; i < paths1.size(); i++ ){
        //     myAns.add( "1" + paths1.get(i) );
        // }


        for (String path: paths1) {
            // myAns.add("1" + path);
            myAns.add(1 + path);
        }

        for (String path: paths2) {
            // myAns.add("2" + path);
            myAns.add(2 + path);
        }

        for (String path: paths3) {
            // myAns.add("3" + path);
            myAns.add(3 + path);
        }
        
        return myAns;
    }

}


/*
        Input---
        
        3
        
        Output---
        
        [111, 12, 21, 3]

*/
