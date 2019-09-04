/*
Given a binary tree, print nodes of extreme corners of each level but in alternate order.
*/

class Node{
    int data;
    Node left,right;
    
    Node(int d)
     {
      data=d;
      left=null;
      right=null;
    }
}
class Extreme{
    public  void printExtremeNode(Node node)
      {
        if(node==null)
        return;
        ArrayList<Node> q=new ArrayList<>();

        int front=0,prev=0;
        boolean flag=true;
        q.add(node);
        q.add(null);
        while(front<q.size()-1)
        {
            Node curr=q.get(front);
            
            if(curr==null)
            {
                q.add(null);
            }
            else
            {
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
                
            }
            front++;
            
        }
        int l=q.size();
        for(front=1;front<l;front++)
        {
            if(q.get(front)==null)
            {
                if(flag==true)
                {
                    System.out.print(q.get(front-1).data+" ");
                    if(front+1<l)
                    System.out.print(q.get(front+1).data+" ");
                }
                flag=!flag;
            }
        }
        return;
      }
      
}
