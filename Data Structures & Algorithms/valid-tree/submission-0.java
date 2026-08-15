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
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(0, 0, -1));
        int[] vis = new int[n];
        vis[0] = 1;
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
