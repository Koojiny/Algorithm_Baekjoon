class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String first = my_string.substring(0, s);
        int idx = overwrite_string.length();
        String last = my_string.substring(s + idx);
        String ans = first + overwrite_string + last;
        return ans;
    }
}