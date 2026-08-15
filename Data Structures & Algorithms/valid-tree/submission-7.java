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
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] c = new int[1];
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            // if(c[0]==1)
            //     return false;
            if(vis[i]==0){
                if(!bfs(i, adj, c, n, vis))
                    return false;
            } 
        }
        return true;
    }

    public boolean bfs(int src, List<List<Integer>> adj, int[] c, int n, int[] vis){
        c[0]++;
        if(c[0]==2)
            return false;  
        Map<Integer, Integer> map = new HashMap<>();
        map.put(src, 0);
        Queue<Triplet> q = new LinkedList<>();
        q.offer(new Triplet(src, 0, -1));
        vis[src] = 1;
        while(!q.isEmpty()){
        Triplet popped = q.poll();
        int node = popped.node;
        int parent = popped.parent;
        int level = popped.level;
        // map.put(node, level);
        for(int adja : adj.get(node)){
            if(vis[adja]==0){
                q.offer(new Triplet(adja, level + 1, node));
                map.put(adja, level + 1);
                vis[adja] = 1;
            }else{
                if(adja != parent && map.get(adja) != level + 1)
                    return false;
            }
        }
        }
        return true;
    }
}
