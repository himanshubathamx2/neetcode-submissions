class Pair{
    int node;
    int parent;
    int level;
    Pair(int node,  int parent,int level){
        this.node = node;
        this.parent = parent;
        this.level = level;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] vis = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                if(!bfs(i, adj, map, vis))
                    return false;
            }
        } 
        return true;  
    }

    public boolean bfs(int src, List<List<Integer>> adj, Map<Integer, Integer> map, int[] vis){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, -1, 0));
        vis[src] = 1;
        map.put(src, 0);
        while(!q.isEmpty()){
            Pair popped = q.poll();
            Integer node = popped.node;
            Integer level = popped.level;
            Integer parent = popped.parent;
            for(int adja : adj.get(node)){
                if(vis[adja]==0){
                    q.offer(new Pair(adja, node, level + 1));
                    vis[adja] = 1;
                    map.put(adja, level + 1);
                }else if(vis[adja]==1 && adja != parent){
                    if(map.get(adja) != (level + 1))
                        return false;
                }
            }
        }
        return true;
    }
}
