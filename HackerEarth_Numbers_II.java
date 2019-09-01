/*
Given two numbers a and b, you have to find the Nth number which is divisible by a or b.

Input :

First line consists of an integer T, denoting the number of test cases.
Second line contains three integers a, b and N .

Output :

For each test case, print the Nth number in a new line.
*/

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String[] in=br.readLine().split(" ");
            int a=Integer.parseInt(in[0]);
            int b=Integer.parseInt(in[1]);
            long n=Long.parseLong(in[2]);
            long low=1, high=Math.max(a,b)*n, mid=0;
            int lcm=(a*b)/gcd(a,b);
            while(low<high)
            {
                mid=low+(high-low)/2;
                
                if(countfact(a,b,lcm,mid)<n)
                low=mid+1;
                else
                high=mid;
            }

            out.println(low);
            t--;
        }
    
         out.close();
         
    }
    
    public static long countfact(int a,int b, int lcm,long num)
    {
        return (num/a)+(num/b)-(num/lcm);
    }
    public static int gcd(int a, int b)
    {
        if(a==0)
        return b;
        
        return gcd(b%a,a);
    }
}
