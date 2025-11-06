class Solution {
    
    public class DisjointSet{

        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n){
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findUltimateParent(int node){
            if(node==parent.get(node)){
                return node;
            }

            int ulp = findUltimateParent(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);

        }

        public void unionBySize(int u, int v){
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);

            if(ulp_u == ulp_v){
                return;
            }

            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
            }
            else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }


    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        DisjointSet ds = new DisjointSet(rows*cols);
        boolean[][] visited = new boolean[rows][cols];
        int count=0;
        List<Integer> ans = new ArrayList<>();
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        
        for(int i=0;i<operators.length;i++){
            int row = operators[i][0];
            int col = operators[i][1];
            
            if(visited[row][col]){
                ans.add(count);
                continue;
            }
            visited[row][col]=true;
            count++;
            
            for(int k=0;k<4;k++){
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                
                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols){
                    if(visited[nrow][ncol]){
                        int nodeNumber = row*cols + col;
                        int newnodeNumber = nrow*cols + ncol;
                        
                        if(ds.findUltimateParent(nodeNumber) != ds.findUltimateParent(newnodeNumber)){
                            count--;
                            ds.unionBySize(nodeNumber,newnodeNumber);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}