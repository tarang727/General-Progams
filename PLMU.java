import java.util.*;
public class PLMU {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			int N=sc.nextInt();
			int a[]=new int[N];
			int i,count_zeroes=0,count_twos=0;
			for(i=0;i<N;i++)
			{
				a[i]=sc.nextInt();
				if(a[i]==0)
					count_zeroes++;
				else if (a[i]==2) {
					count_twos++;
				}
			}
			
			int ans=((count_zeroes*(count_zeroes-1))/2) + ((count_twos*(count_twos-1))/2);
			System.out.println(ans);
		}
	}

}
