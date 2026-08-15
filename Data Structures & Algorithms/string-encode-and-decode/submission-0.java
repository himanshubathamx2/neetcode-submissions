class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String word : strs){
            sb.append(word+":ab");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        String[] split= str.split(":ab");
        List<String> ans = new ArrayList<>();
        for(String word : split){
            ans.add(word);
        }
        return ans;
    }
}
