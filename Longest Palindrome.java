public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int cnt = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            int freq = entry.getValue();
            if (freq > 1)                
                cnt += (freq / 2) * 2;
            
            if (freq % 2 == 1)                 
                one = 1;    
        }
        
        return cnt + one;
    }
}
