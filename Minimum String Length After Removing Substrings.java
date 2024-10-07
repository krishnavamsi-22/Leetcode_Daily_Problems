class Solution {
    public int minLength(String s) {

        Stack<Character> str = new Stack<>();

        for(int i = 0;i<s.length();i++){
            if(str.empty()){
                str.push(s.charAt(i));
            }else if((str.peek()=='A' && s.charAt(i)=='B') || (str.peek()=='C' && s.charAt(i)=='D')){
                str.pop();
            }else{
                str.push(s.charAt(i));
            }
        }

        return str.size();
        
    }
}
