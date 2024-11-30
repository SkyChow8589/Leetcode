package DP_One_Dimension;

public class LongestValidParentheses32 {
    // 时间复杂度O(n)，n是str字符串的长度
    public static int longestValidParentheses(String str) {
        char[] s = str.toCharArray();
        // dp[0...n-1]
        // dp[i] : 子串必须以i位置的字符结尾的情况下，往左整体有效的最大长度
        int[] dp = new int[s.length];
        int ans = 0;
        for (int i = 1, p; i < s.length; i++) {
            if (s[i] == ')') {
                p = i - dp[i - 1] - 1;
                //  ?         )
                //  p         i
                if (p >= 0 && s[p] == '(') {
                    dp[i] = dp[i - 1] + 2 + (p - 1 >= 0 ? dp[p - 1] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
