class Triplet{
    int node;
    int level;
    int parent;
    Triplet(int node, int level, int parent){
        this.node = node;
        this.level = level;
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
        Queue<Triplet> q = new LinkedList<>();
        q.offer(new Triplet(i, 0, -1));
        vis[i] = 1;
        while(!q.isEmpty()){
            Triplet popped = q.poll();
            int node = popped.node;
            int parent = popped.parent;
            int level = popped.level;
            for(int adja : adj.get(node)){
                if(vis[adja] == 0){
                    q.offer(new Triplet(adja, level + 1, node));
                    vis[adja] = 1;
                }else if(vis[adja] == 1 && adja != parent){
                    return false;
                }
            }
        }
        return true;
    }














}
