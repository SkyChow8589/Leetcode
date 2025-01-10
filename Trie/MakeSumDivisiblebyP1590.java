package Trie;

import java.util.HashMap;

public class MakeSumDivisiblebyP1590 {
    public static int minSubarray(int[] nums, int p) {
        // 整体余数
        int mod = 0;
        for (int num : nums) {
            mod = (mod + num) % p;
        }
        if (mod == 0) {
            return 0;
        }
        // key : 前缀和%p的余数
        // value : 最晚出现的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0, cur = 0, find; i < nums.length; i++) {
            // 0...i这部分的余数
            cur = (cur + nums[i]) % p;
            find = cur >= mod ? (cur - mod) : (cur + p - mod);
            // find = (cur + p - mod) % p;
            if (map.containsKey(find)) {
                ans = Math.min(ans, i - map.get(find));
            }
            map.put(cur, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}
