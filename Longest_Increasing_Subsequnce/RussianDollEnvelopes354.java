package Longest_Increasing_Subsequnce;

import java.util.Arrays;

public class RussianDollEnvelopes354 {
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 排序策略:
        // 宽度从小到大
        // 宽度一样，高度从大到小
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? (a[0] - b[0]) : (b[1] - a[1]));
        int[] ends = new int[n];
        int len = 0;
        for (int i = 0, find, num; i < n; i++) {
            num = envelopes[i][1];
            find = bs(ends, len, num);
            if (find == -1) {
                ends[len++] = num;
            } else {
                ends[find] = num;
            }
        }
        return len;
    }

    public static int bs(int[] ends, int len, int num) {
        int l = 0, r = len - 1, m, ans = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (ends[m] >= num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
