class Triplet{
    int node;
    int parent;
    int level;
    Triplet(int node, int parent, int level){
        this.node = node;
        this.parent = parent;
        this.level = level;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Triplet> q = new LinkedList<>();
        int[] vis = new int[n];
        q.offer(new Triplet(0, -1, 0));
        vis[0] = 1;
        map.put(0, 0);
        while(!q.isEmpty()){
            Triplet popped = q.poll();
            int node = popped.node;
            int parent = popped.parent;
            int level = popped.level;
            map.put(node, level);
            // if(parent!=-1 && map.get(parent) != level -1)
            //     return false;    
            for(int adja : adj.get(node)){
                if(vis[adja] == 0){
                    q.offer(new Triplet(adja, node, level + 1));
                    map.put(adja, level+1);
                    vis[adja] = 1;
                }else{
                    if(adja != parent &&  map.get(adja) != level+1)
                        return false;
                }
            }
        }
        return true;
    }
}
