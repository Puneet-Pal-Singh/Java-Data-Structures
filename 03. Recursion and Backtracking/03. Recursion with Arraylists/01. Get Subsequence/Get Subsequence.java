import java.io.*;
import java.util.*;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        ArrayList<String> ans=gss(str);
        System.out.println(ans);
    }
    public static ArrayList<String> gss(String str) 
    {   
        // base Case
        if(str.length()==0)
        {
            ArrayList<String>baseAns=new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        //
        ArrayList<String> recAns=gss(str.substring(1));
        // 0th character
        char ch=str.charAt(0);
        // Making var for storing char
        ArrayList<String> myAns=new ArrayList<>();
        // If no call
        for(int i=0;i<recAns.size();i++)
        {
            myAns.add(recAns.get(i));
        }
        // If yes call
        for(int i=0;i<recAns.size();i++)
        {
            myAns.add(ch+recAns.get(i));
        }
        return myAns;
    }
}



/*
        Input---
        
        abc
        
        Output---
        
        [, c, b, bc, a, ac, ab, abc]

*/