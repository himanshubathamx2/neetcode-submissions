class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }   
        System.out.println(sb);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str);
        while(!sb.isEmpty()){
            int hashIdx = sb.indexOf("#");
            int len = Integer.parseInt(sb.substring(0, hashIdx));
            sb.delete(0, hashIdx + 1);
            ans.add(sb.substring(0, len));
            sb.delete(0, len);    
        }
        return ans;
    }
}
