/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    static class Tuple{
        Node node;
        int row;
        int col;
        
        public Tuple(Node _node, int _row, int _col){
            node = _node;
            row = _row;
            col = _col;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> bottomView(Node root) {
        // code here
        TreeMap<Integer,TreeMap<Integer,Queue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.offer(new Tuple(root,0,0));
        
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            Node node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new LinkedList<>());
            }
            map.get(x).get(y).offer(node.data);
            
            if(node.right!=null){
                queue.offer(new Tuple(node.right,x+1,y+1));
            }
            
            if(node.left!=null){
                queue.offer(new Tuple(node.left,x-1,y+1));
            }
            
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(TreeMap<Integer,Queue<Integer>> itr : map.values()){
            int temp = itr.lastKey();
            list.add(itr.get(temp).peek());
        }
        
        
        return list;
    }
}