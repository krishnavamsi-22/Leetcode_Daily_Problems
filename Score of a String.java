class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int j = i+1;
            sum += Math.abs((int) s.charAt(i) - (int) s.charAt(j));
        }
        return sum;
        
    }
}
