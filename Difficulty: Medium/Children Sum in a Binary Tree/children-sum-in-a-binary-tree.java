/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        
        int leftvalue=0;
        int rightvalue=0;
        
        if(root.left!=null){
            leftvalue=root.left.data;
        }
        
        if(root.right!=null){
            rightvalue=root.right.data;
        }
        
        if((leftvalue+rightvalue)==root.data){
            return isSumProperty(root.left) && isSumProperty(root.right);
        }
        
        return false;
    }
}