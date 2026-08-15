class Pair{
    int node;
    int level;
    int parent;
    Pair(int node, int level, int parent){
        this.node = node;
        this.level = level;
        this.parent = parent;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // Remove this for a directed graph
        }
        int c = 0;
        for(int i=0;i<n;i++){
            // if(c==1)
            //     return false;
            if(vis[i]==0){
                c++;
                if(!bfs(i, adj, vis))
                   return false;   
            }
        }
        return true;
    }
    public boolean bfs(int n, List<List<Integer>> adj, int[] vis){
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(n, 0, -1));
        vis[n] = 1;
        while(!q.isEmpty()){
            Pair popped = q.poll();
            int node = popped.node;
            int level = popped.level;
            int parent = popped.parent;
            map.put(node, level);
            for(int adja : adj.get(node)){
                if(vis[adja] == 0){
                    q.offer(new Pair(adja, level+1, node));
                    vis[adja] = 1;
                }else{
                    if(map.containsKey(adja)){
                        if(adja != parent && map.get(adja) != level+1){
                            return false;
                        }
                    }
                }    
            }
        }
        return true;
    }

}
