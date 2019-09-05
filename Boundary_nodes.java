/*
Write a function to print Boundary Traversal of a binary tree. Boundary Traversal of a binary tree here means that 
you have to print boundary nodes of the binary tree Anti-Clockwise starting from the root.
Note: Boundary node means nodes present at boundary of leftSubtree and nodes present at rightSubtree also including 
leaf nodes.
*/

class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Boundary
{
	void printBoundary(Node node)
	{
	    if(node==null)
	    return;
	    System.out.print(node.data+" ");
	    if(node.left==null && node.right==null)
	    return;
		Node temp=node.left;
		leftnodes(temp);
		temp=node;
		leafnodes(temp);
		temp=node.right;
		rightnodes(temp);
		return;
	}
	void leftnodes(Node root)
	{
	    if(root==null)
	    return;
	    if(root.left==null && root.right==null)
	    return;
	    
	    System.out.print(root.data+" ");
	    if(root.left!=null)
	    leftnodes(root.left);
	    else
	    leftnodes(root.right);
	}
	void leafnodes(Node root)
	{
	    if(root==null)
	    return;
	    if(root.left==null && root.right==null)
	    {
	        System.out.print(root.data+" ");
	        return;
	    }
	    leafnodes(root.left);
	    leafnodes(root.right);
	    
	}
	void rightnodes(Node root)
	{
	    if(root==null)
	    return;
	    if(root.right==null && root.left==null)
	    return;
	    
	    if(root.right!=null)
	    rightnodes(root.right);
	    else
	    rightnodes(root.left);
	    System.out.print(root.data+" ");
	}
}
