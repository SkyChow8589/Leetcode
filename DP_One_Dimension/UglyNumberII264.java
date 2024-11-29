package DP_One_Dimension;

public class UglyNumberII264 {
    // 时间复杂度O(n)，n代表第n个丑数
    public static int nthUglyNumber(int n) {
        // dp 0 1 2 ...  n
        //      1 2 ...  ?
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2, i2 = 1, i3 = 1, i5 = 1, a, b, c, cur; i <= n; i++) {
            a = dp[i2] * 2;
            b = dp[i3] * 3;
            c = dp[i5] * 5;
            cur = Math.min(Math.min(a, b), c);
            if (cur == a) {
                i2++;
            }
            if (cur == b) {
                i3++;
            }
            if (cur == c) {
                i5++;
            }
            dp[i] = cur;
        }
        return dp[n];
    }
}
