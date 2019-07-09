import java.util.*;
import java.io.*;

class NumberofPrime {
	static int maxn=1000000;
	static boolean seive[]=new boolean[maxn+1];
	static int numprime[]=new int[maxn+1];
	
	public static void createSeive() {
		int i,j;
		for(i=2;i<=maxn;i++)
		{
			seive[i]=true;
		}
		
		for(i=2;i*i<=maxn;i++)
		{
			if(seive[i])
			{
				for(j=i*i;j<=maxn;j+=i)
				{
					seive[j]=false;
				}
			}
		}
	}
	
	public static void findnumprime()
	{
		createSeive();
		int i,count=0;
				
		for(i=2;i<=maxn;i++)
		{
			if(seive[i])
			{
				count++;
			}
			numprime[i]=count;
		}
	}
	
	public static void main(String args[]) {
		findnumprime();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(numprime[n]);
		//System.out.println();

	}
}
