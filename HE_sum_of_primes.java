import java.io.*;
import java.util.*;

public class HE_sum_of_primes {
	static PrintWriter out=new PrintWriter(System.out);
	static int maxn=1000000;
	static boolean seive[]=new boolean[maxn+1];
	static long sum_primes[]=new long[maxn+1];
	public static void create_seive() {
		int i,j;
		
		for(i=2;i<=maxn;i++)
			seive[i]=true;
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
	public static void init()
	{
		create_seive();
		int i;
		long sum=0;
		for(i=2;i<=maxn;i++)
		{
			if(seive[i])
				sum+=i;
			sum_primes[i]=sum;
		}
		
	}
	public static void main(String[] args) throws Exception {
		init();
		int t;
		Scanner sc = new Scanner(System.in);
		//		System.out.println("Enter string : ");
		t = sc.nextInt();
		while (t > 0) {
			int l=sc.nextInt();
			int r=sc.nextInt();
			
			out.println(sum_primes[r]-sum_primes[l-1]);

			t--;
		}
		out.close();
		sc.close();
	}
}
