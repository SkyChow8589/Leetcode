package Longest_Increasing_Subsequnce;

import java.util.Arrays;

public class MaximumLengthofPairChain646 {
    public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        // 数对根据开始位置排序，从小到大
        // 结束位置无所谓！
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        // 结尾的数值
        int[] ends = new int[n];
        int len = 0;
        for (int[] pair : pairs) {
            int find = bs(ends, len, pair[0]);
            if (find == -1) {
                ends[len++] = pair[1];
            } else {
                ends[find] = Math.min(ends[find], pair[1]);
            }
        }
        return len;
    }

    // >= num最左位置
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

    // 最优解利用贪心
    public static int findLongestChain2(int[][] pairs) {
        int pre = Integer.MIN_VALUE, ans = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int[] pair : pairs) {
            if (pre < pair[0]) {
                pre = pair[1];
                ans++;
            }
        }
        return ans;
    }
}
