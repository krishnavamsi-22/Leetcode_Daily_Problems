class Solution {
  public:
    vector<int> computeLPSArray(string& pat) {
        int n = pat.size();
        vector<int> lps(n);

        int len = 0; 
        lps[0] = 0;  

        int i = 1;
        while (i < n) {
            if (pat[i] == pat[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    bool areRotations(string &s1, string &s2) {
        if (s1.length() != s2.length()) return false;
        string txt = s1 + s1;
        string pat = s2;
        int n = txt.length();
        int m = pat.length();
        vector<int> lps = computeLPSArray(pat);

        int i = 0; 
        int j = 0; 

        while (i < n) {
            if (pat[j] == txt[i]) {
                j++;
                i++;
            }

            if (j == m) {
                return true;
            }

            if (i < n && pat[j] != txt[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }
};
