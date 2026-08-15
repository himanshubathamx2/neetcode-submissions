class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String word : strs){
            sb.append(word.length()).append("#").append(word);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        if(n == 0)
            return ans; 
        StringBuilder sb = new StringBuilder(s);  
        while(!sb.isEmpty()){
            int hashI = sb.indexOf("#");
            int len = Integer.parseInt(sb.substring(0, hashI));
            String word = sb.substring(hashI + 1, hashI + 1 + len);
            sb.delete(0, hashI + 1 + len);
            ans.add(word);            
        }
        return ans;
    }
}
