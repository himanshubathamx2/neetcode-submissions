class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for (String s : strs) {
            encodedStr.append(s.length()).append("#").append(s);
        }
        System.out.println(encodedStr.toString());
        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        // 4#neet4#code4#love3#you
        StringBuilder sb = new StringBuilder(str);
        List<String> decodedList = new ArrayList<>();
        while(sb.length() > 0){
            int index = sb.indexOf("#");   
            int len = Integer.parseInt(sb.substring(0, index));
            sb.delete(0, index+1);
            String word = sb.substring(0, len);
            System.out.println(word);
            sb.delete(0, len);
            decodedList.add(word);
        }
        return decodedList;
    }
}
