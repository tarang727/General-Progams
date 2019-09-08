/* Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of 
nodes visible when the tree is viewed from the top. For the given below tree :

       1
    /     \
   2       3
  /  \    /  \
4     5  6     7

Top view will be: 4 2 1 3 7
Note: Print from leftmost node to rightmost node. 
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
class View
{
    static class Pair
    {
        int hd;
        Node node;
        Pair(Node t, int h)
        {
            node=t;
            hd=h;
        }
    }
    // function should print the topView of the binary tree
    static void topView(Node root)
    {
        Map<Integer,Node> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        Node temp=root;
        q.add(new Pair(temp,0));
        int hd=0;
        
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            hd=curr.hd;
            if(!map.containsKey(hd))
            map.put(hd,curr.node);
            
            if(curr.node.left!=null)
            {
                q.add(new Pair(curr.node.left,hd-1));
            }
            if(curr.node.right!=null)
            {
                q.add(new Pair(curr.node.right,hd+1));
            }
        }

        map.forEach((k,v)->System.out.print(v.data+" "));
        
    }
}
