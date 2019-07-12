import java.util.*;
import java.io.*;

public class Subtree_max_avg {
	
	static double maxavg=Integer.MIN_VALUE*1.0;
	
	static class Node {
		int key;
		Node left,right;
	}
	
	static class ResultType {
		int sum,size;
		ResultType(int s1,int s2)
		{
			sum=s1;
			size=s2;
		}
	}
	
	static Node newNode(int val)
	{
		Node n=new Node();
		n.key=val;
		n.left=null;
		n.right=null;
		return n;
	}
	
	static Node subtree=null;;
	
	static ResultType findavg(Node root)
	{
		if(root==null)
			return new ResultType(0,0);
		
		ResultType left=findavg(root.left);
		ResultType right=findavg(root.right);
		int currsum=root.key+left.sum+right.sum;
		int currsize=left.size+right.size+1;
		
		if(currsum>maxavg*currsize)
		{
			maxavg=(currsum*1.0)/currsize;
			subtree=root;
		}
		
		return new ResultType(currsum,currsize);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

	    Node root = newNode(2);  
	    root.left = newNode(-2);  
	    root.right = newNode(14);  
	    root.left.left = newNode(-1);  
	    root.left.right = newNode(1);  
	    root.right.left = newNode(5);  
	    root.right.right = newNode(-1); 
	    findavg(root);
		System.out.println(subtree.key);

	}
}
