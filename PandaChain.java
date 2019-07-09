import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class PandaChain {
	static BigInteger one=BigInteger.ONE;
	static BigInteger ten=BigInteger.TEN;

	static int mod=1000003;
	static BigInteger maxx=new BigInteger("1000000000000000000");
	static BigInteger arr[]=new BigInteger[mod+1];
	
	public static void init() {
		arr[0]=one;
		for(int i=1;i<=mod;i++)
		{
			arr[i]=(arr[i-1].multiply(BigInteger.valueOf(i))).mod(BigInteger.valueOf(mod));
		}
	}
	public static void main(String args[]) {
		init();
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		
		while(t>0)
		{
			String s1=sc.next();
			String s2=sc.next();
			BigInteger n=new BigInteger(s1);
			BigInteger x=new BigInteger(s2);
			
			x=x.mod(BigInteger.valueOf(mod));
			if(n.compareTo(BigInteger.valueOf(mod))>0)
			{
				n=BigInteger.valueOf(mod);
			}
			BigInteger ans=(arr[n.intValue()].multiply(x)).mod(BigInteger.valueOf(mod));
			System.out.println(ans);
			
			t--;
		}
		//System.out.println();

	}

}
