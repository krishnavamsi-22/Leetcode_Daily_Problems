class Solution {
    public int subsetXORSum(int[] nums) {
        int total = 0;
        for (int i = 0; i < (1 << nums.length); i++) {
            int subsetXOR = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subsetXOR ^= nums[j];
                }
            }
            total += subsetXOR;
        }
        return total;
    }
}
