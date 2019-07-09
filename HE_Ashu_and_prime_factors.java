import java.util.*;

public class HE_Ashu_and_prime_factors {
	
	static int maxn=1000000;
	static int minprime[]=new int[maxn+1];
	static int count[]=new int[maxn+1];
	static HashMap <Integer,Integer> hp=new HashMap<>();
	public static void init() {
		int i,j,c;
		for(i=2;i*i<=maxn;i++)
		{
			if(minprime[i]==0)
			{
				minprime[i]=i;
				c=1;
				for(j=i*i;j<=maxn;j+=i)
				{
					if(minprime[j]==0)
					{
						minprime[j]=i;
						c++;
					}
				}
				count[i]=c;
					
			}
		}
		
		for(i=2;i<=maxn;i++)
		{
		    if(count[i]==0)
		    count[i]=1;
		}
	
		
		
	}
	public static void main(String[] args) {
		init();
		int t;
		Scanner sc = new Scanner(System.in);
		//		System.out.println("Enter string : ");
		t = sc.nextInt();
		while (t > 0) {
			int x=sc.nextInt();
			
			System.out.println(count[x]);
			
			

			t--;
		}
		sc.close();
	}
}
