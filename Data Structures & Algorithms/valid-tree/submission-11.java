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
    public boolean validTree(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int[] vis = new int[V];
        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                if(!bfs(i, adjList, vis)){
                   return false; 
                }
            }
        }
        return true;
    }

    public boolean bfs(int node, List<List<Integer>> adj, int[] vis){
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        q.offer(new Pair(node, 0, -1));
        vis[node] = 1;
        map.put(node, 0);
        while(!q.isEmpty()){
            Pair popped = q.poll();
            int i = popped.node;
            int level = popped.level;
            int parent = popped.parent;
            
            for(int adja : adj.get(i)){
                if(vis[adja] == 0){
                    q.offer(new Pair(adja, level + 1, i));
                    vis[adja] = 1;  
                    map.put(adja, level + 1);
                }else{
                    if(adja != parent && level + 1 != map.get(adja))
                        return false;
                }
            }
        }
        return true;
    }
}
