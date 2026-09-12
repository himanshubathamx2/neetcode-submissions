class Pain{
    int node;
    int parent;
    Pain(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public boolean validTree(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        } 

        int[] vis = new int[V];
        int c = 0;
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                if(c==1)
                    return false;
                if(!bfs(i, adj, vis)){
                    return false;
                }
                c++;  
            }
        }
        return true;
    }

    public boolean bfs(int i, List<List<Integer>> adj, int[] vis){
        Queue<Pain> q = new LinkedList<>();
        q.offer(new Pain(i, -1));
        vis[i] = 1;
        while(!q.isEmpty()){
            Pain popped = q.poll();
            int node = popped.node;
            int parent = popped.parent;
            for(int adja : adj.get(node)){
                if(vis[adja] == 0){
                    q.offer(new Pain(adja, node));
                    vis[adja] = 1;
                }else if(adja != parent){
                    return false;
                }
            }
        }
        return true;
    }














}
