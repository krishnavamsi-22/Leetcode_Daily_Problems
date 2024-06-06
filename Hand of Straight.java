class Solution {
    public boolean isNStraightHand(int[] arr, int size) {
        if (arr.length % size != 0) {
            return false;
        }
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        while (!list.isEmpty()) {
            int first = list.get(0);
            for (int i = 0; i < size; i++) {
                if (!list.remove((Integer) (first + i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
