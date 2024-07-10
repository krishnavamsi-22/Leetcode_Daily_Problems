class Solution {
    public int minOperations(String[] s) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("../")) {
                if (!st.empty()) {
                    st.pop();
                }
            } else if (s[i].equals("./")) {
                continue;
            } else {
                int index = s[i].indexOf('/');
                if (index != -1) {
                    String result = s[i].substring(0, index);
                    st.push(result);
                }
            }
        }

        return st.size();
    }
}
