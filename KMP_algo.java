import java.util.*;
import java.io.*;

public class KMP_algo {
	
	public static void kmp(String pat,String text) {
		int p=pat.length();
		int t=text.length();
		int lps[]=new int[p];
		
		lps[0]=0;
		int i=1;
		int len=0;
		while(i<p)
		{
			if(pat.charAt(i)==pat.charAt(len))
			{
				len++;
				lps[i]=len;
				i++;
			}
			else if(len>0)
			{
				len=lps[len-1];
				
			}
			else if(len==0)
			{
				lps[i]=0;
				i++;
			}
		}

		i=0;
		int j=0;

		while(i<t)
		{
			if(pat.charAt(j)==text.charAt(i))
			{
				System.out.println("Yes");
				i++;
				j++;
			}
			System.out.println(j);
			if(j==p)
			{
				System.out.println("Found");
				j=lps[j-1];
			}
			else if(i<t && text.charAt(i)!=pat.charAt(j));
			{
				if(j>0)
					j=lps[j-1];
				else
					i++;
			}
		}
		
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String pat=sc.nextLine();
		String text=sc.nextLine();
	//	System.out.println(pat+" "+text);
		kmp(pat,text);
		

	}
}
