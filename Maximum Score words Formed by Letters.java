public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int res = 0;
        int[] letters_count = new int[26];
        for (char letter : letters) {
            int ind = letter - 'a';
            letters_count[ind] += 1;
        }
        Map<String, Integer> words_scores = new HashMap<>();
        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int ind = c - 'a';
                s += score[ind];
            }
            words_scores.put(word, s);
        }

        for (int mask = 0; mask < (1 << n); ++mask) { 
            int[] cur_count = new int[26];
            boolean can_create = true;
            int cur_score = 0;

            for (int word_ind = 0; word_ind < n; ++word_ind) {
                if ((mask & (1 << word_ind)) != 0) { 
                    String word = words[word_ind];
                    cur_score += words_scores.get(word);
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        int ind = c - 'a';
                        cur_count[ind]++;
                        if (cur_count[ind] > letters_count[ind]) {
                            can_create = false;
                            break;
                        }
                    }
                }
                if (!can_create) {
                    break;
                }
            }
            if (can_create && cur_score > res) {
                res = cur_score;
            }
        }

        return res;
    }
}
