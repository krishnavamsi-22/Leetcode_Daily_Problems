class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.empty() || nums[st.peek()]>nums[i]){
                st.push(i);
            }
        }
        int maxi = Integer.MIN_VALUE;
        for(int j = n-1;j>=0;j--){
            while(!st.empty() && nums[st.peek()]<=nums[j]){
                maxi = Math.max(maxi,j-st.pop());
            }
        }
        return maxi;
        
    }
}
