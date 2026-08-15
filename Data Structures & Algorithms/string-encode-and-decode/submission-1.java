class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for (String s : strs) {
            encodedStr.append(s.length()).append("#").append(s);
        }
        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // Find the delimiter to extract the length
            int j = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1; // Move past the delimiter
            decodedList.add(str.substring(i, i + length));
            i += length; // Move to the next encoded string
        }
        return decodedList;
    }
}
