package Trie;

public class MaximumSizeSubarraySumEqualsk325 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int maxSubArrayLen(int[] nums, int k) {
        map.clear();
        map.put(0, -1);
        int ans = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
