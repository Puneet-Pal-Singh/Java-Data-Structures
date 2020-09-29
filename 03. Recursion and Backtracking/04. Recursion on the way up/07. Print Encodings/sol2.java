import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        } else if (ques.length() == 1) {
            char ch = ques.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int ch0 = ch - '0';                         // change is here
                String roq0 = ques.substring(1);
                char code0 = (char)('a' + ch0 - 1);         // char used here
                printEncodings(roq0, ans + code0);
            }
        } else {
            char ch = ques.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int ch0 = ch - '0';
                String roq0 = ques.substring(1);
                char code0 = (char)('a' + ch0 - 1);
                printEncodings(roq0, ans + code0);

                String ch01 = ques.substring(0, 2);
                String roq01 = ques.substring(2);

                // String code01 = (char)("a" + (Integer.parseInt(ch01) - 1)) + "";
                // String code01 = (char)("a" + ch01 - 1) + "";

                int ch01v = Integer.parseInt(ch01);
                if (ch01v <= 26) {
                    // if (Integer.parseInt(ch01) <= 26) {
                    char code01 = (char)('a' + ch01v - 1);
                    printEncodings(roq01, ans + code01);
                }
            }
        }
    }
}


/*
        Sample Input

        123

        Sample Output

        abc
        aw
        lc

*/
