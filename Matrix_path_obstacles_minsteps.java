import java.util.*;
import java.io.*;

public class Matrix_path_obstacles_minsteps {
	static int V;
	static int N;
	static LinkedList<Integer> adjmat[];
	static int mat[][];
	public static void init()
	{
		adjmat=new LinkedList[V];
		int i;
		for(i=0;i<V;i++)
		{
			adjmat[i]=new LinkedList<>();
		}
	}
	
	public static void addedge(int a,int b)
	{
		adjmat[a].add(b);
		adjmat[b].add(a);
	}
	
	public static int minPath()
	{
		int i,j,d=0,k=1;
		
		for(i=0;i<N;i++)
		{
			for(j=0;j<N;j++)
			{
				if(mat[i][j]!=0)
				{
					if(isSafe(i,j+1))
					{
						addedge(k,k+1);
					}
					if(isSafe(i,j-1))
					{
						addedge(k,k-1);
					}
					if( j<N-1  &&  isSafe(i+1,j))
					{
						addedge(k,k+N);
					}
					if(isSafe(i,j+1))
					{
						addedge(k,k+1);
					}
				}
				if(mat[i][j]==2)
					d=k;
				
				k++;
			}
		}
		return (BFS(d));
		
	}
	
	public static int BFS(int d) {
		
		int level[]=new int[V];
		Queue<Integer> q=new LinkedList<>();
		int i,j;
		
		for(i=0;i<V;i++)
		{
			level[i]=-1;
		}
		
		q.add(1);
		level[1]=0;
		
		while(!q.isEmpty())
		{
			int s=q.poll();
			
			for(Integer v:adjmat[s])
			{
				if(level[v]==-1||level[v]>level[s]+1)
				{
					q.add(v);
					level[v]=level[s]+1;
				}
				
			}
		}
		return level[d];
	}
	
	public static boolean isSafe(int i, int j) 
	{ 
	    if ((i < 0 || i >= N) || 
	            (j < 0 || j >= N ) || mat[i][j] == 0) 
	        return false; 
	    return true; 
	} 
 
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		V=(N*N)+2;
		init();
		mat = new int[N][N];
		int i,j;
		for(i=0;i<N;i++)
		{
			for(j=0;j<N;j++)
			{
				mat[i][j]=sc.nextInt();
			}
		}
		int min=minPath();
		System.out.println(min);

	}
}
