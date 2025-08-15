
class Solution {
    Node mergeLists(Node root1, Node root2){
        Node dummyhead = new Node(-1);
        Node res=dummyhead;
        while(root1!=null && root2!=null){
            if(root1.data<root2.data){
                res.bottom=root1;
                res=root1;
                root1=root1.bottom;
            }
            else{
                res.bottom=root2;
                res=root2;
                root2=root2.bottom;
            }
            res.next=null;
        }
        
        if(root1!=null){
            res.bottom=root1;
        }
        if(root2!=null){
            res.bottom=root2;
        }
        return dummyhead.bottom;
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root==null || root.next==null){
            return root;
        }
        
        Node curr=root;
        Node next=root.next;
        while(next!=null){
            Node temp=next.next;
            curr=mergeLists(curr,next);
            next=temp;
        }
        
        return curr;
    }
}