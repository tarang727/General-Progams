/*
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines.
First line of each test case consist of a integer N, denoting the number of element in a Trie to be stored.
Second line of each test case consists of N space separated strings denoting the elements to be stored in the trie.
Third line of each test case consists of a String A to be searched in the stored elements.
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class Trie {
    static class Node {
        Node child[]=new Node[26];
        boolean isword;
    }
    
    static void insert(Node root, String key)
    {
        int l=key.length(),i,index;
        Node temp=root;
        
        for(i=0;i<l;i++)
        {
            index=key.charAt(i)-'a';
            
            if(temp.child[index]==null)
            temp.child[index]=new Node();
            
            temp=temp.child[index];
        }
        
        temp.isword=true;
        
    }
    
    static int search(Node root, String key)
    {
        int l=key.length(),i,index;
        Node temp=root;
        
        
        for(i=0;i<l;i++)
        {
            index=key.charAt(i)-'a';
            
            if(temp.child[index]==null)
            return 0;
            
            temp=temp.child[index];
        }
        
        if(temp!=null && temp.isword==true)
        return 1;
        else
        return 0;
    }
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    PrintWriter out=new PrintWriter(System.out);
	    
		Node root=new Node();
		int t=sc.nextInt();
		
		while(t>0)
		{
		    int n=sc.nextInt(),i;
		    for(i=0;i<n;i++)
		    {
		        insert(root,sc.next());
		    }
		    
		    System.out.println(search(root,sc.next()));
		    t--;
		}
	}
}
