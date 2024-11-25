package DP_One_Dimension;

import java.util.Arrays;

public class DecodeWays91 {
    // 暴力尝试
    public static int numDecodings1(String s) {
        return f1(s.toCharArray(), 0);
    }

    // s : 数字字符串
    // s[i....]有多少种有效的转化方案
    public static int f1(char[] s, int i) {
        if (i == s.length) {
            return 1;
        }
        int ans;
        if (s[i] == '0') {
            ans = 0;
        } else {
            ans = f1(s, i + 1);
            if (i + 1 < s.length && ((s[i] - '0') * 10 + s[i + 1] - '0') <= 26) {
                ans += f1(s, i + 2);
            }
        }
        return ans;
    }

    // 暴力尝试改记忆化搜索
    public static int numDecodings2(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return f2(s.toCharArray(), 0, dp);
    }

    public static int f2(char[] s, int i, int[] dp) {
        if (i == s.length) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans;
        if (s[i] == '0') {
            ans = 0;
        } else {
            ans = f2(s, i + 1, dp);
            if (i + 1 < s.length && ((s[i] - '0') * 10 + s[i + 1] - '0') <= 26) {
                ans += f2(s, i + 2, dp);
            }
        }
        dp[i] = ans;
        return ans;
    }

    // 严格位置依赖的动态规划
    public static int numDecodings3(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length && ((s[i] - '0') * 10 + s[i + 1] - '0') <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    // 严格位置依赖的动态规划 + 空间压缩
    public static int numDecodings4(String s) {
        // dp[i+1]
        int next = 1;
        // dp[i+2]
        int nextNext = 0;
        for (int i = s.length() - 1, cur; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                cur = 0;
            } else {
                cur = next;
                if (i + 1 < s.length() && ((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0') <= 26) {
                    cur += nextNext;
                }
            }
            nextNext = next;
            next = cur;
        }
        return next;
    }
}
