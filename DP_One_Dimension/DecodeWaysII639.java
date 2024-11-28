package DP_One_Dimension;

import java.util.Arrays;

public class DecodeWaysII639 {
    // 没有取模逻辑
    // 最自然的暴力尝试
    public static int numDecodings1(String str) {
        return f1(str.toCharArray(), 0);
    }

    // s[i....] 有多少种有效转化
    public static int f1(char[] s, int i) {
        if (i == s.length) {
            return 1;
        }
        if (s[i] == '0') {
            return 0;
        }
        // s[i] != '0'
        // 2) i想单独转
        int ans = f1(s, i + 1) * (s[i] == '*' ? 9 : 1);
        // 3) i i+1 一起转化 <= 26
        if (i + 1 < s.length) {
            // 有i+1位置
            if (s[i] != '*') {
                if (s[i + 1] != '*') {
                    // num num
                    //  i  i+1
                    if ((s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                        ans += f1(s, i + 2);
                    }
                } else {
                    // num  *
                    //  i  i+1
                    if (s[i] == '1') {
                        ans += f1(s, i + 2) * 9;
                    }
                    if (s[i] == '2') {
                        ans += f1(s, i + 2) * 6;
                    }
                }
            } else {
                if (s[i + 1] != '*') {
                    // *  num
                    // i  i+1
                    if (s[i + 1] <= '6') {
                        ans += f1(s, i + 2) * 2;
                    } else {
                        ans += f1(s, i + 2);
                    }
                } else {
                    // *  *
                    // i  i+1
                    // 11 12 ... 19 21 22 ... 26 -> 一共15种可能
                    // 没有10、20，因为*只能变1~9，并不包括0
                    ans += f1(s, i + 2) * 15;
                }
            }
        }
        return ans;
    }

    public static long mod = 1000000007;

    public static int numDecodings2(String str) {
        char[] s = str.toCharArray();
        long[] dp = new long[s.length];
        Arrays.fill(dp, -1);
        return (int) f2(s, 0, dp);
    }

    public static long f2(char[] s, int i, long[] dp) {
        if (i == s.length) {
            return 1;
        }
        if (s[i] == '0') {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        long ans = f2(s, i + 1, dp) * (s[i] == '*' ? 9 : 1);
        if (i + 1 < s.length) {
            if (s[i] != '*') {
                if (s[i + 1] != '*') {
                    if ((s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                        ans += f2(s, i + 2, dp);
                    }
                } else {
                    if (s[i] == '1') {
                        ans += f2(s, i + 2, dp) * 9;
                    }
                    if (s[i] == '2') {
                        ans += f2(s, i + 2, dp) * 6;
                    }
                }
            } else {
                if (s[i + 1] != '*') {
                    if (s[i + 1] <= '6') {
                        ans += f2(s, i + 2, dp) * 2;
                    } else {
                        ans += f2(s, i + 2, dp);
                    }
                } else {
                    ans += f2(s, i + 2, dp) * 15;
                }
            }
        }
        ans %= mod;
        dp[i] = ans;
        return ans;
    }

    public static int numDecodings3(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] != '0') {
                dp[i] = (s[i] == '*' ? 9 : 1) * dp[i + 1];
                if (i + 1 < n) {
                    if (s[i] != '*') {
                        if (s[i + 1] != '*') {
                            if ((s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            if (s[i] == '1') {
                                dp[i] += dp[i + 2] * 9;
                            }
                            if (s[i] == '2') {
                                dp[i] += dp[i + 2] * 6;
                            }
                        }
                    } else {
                        if (s[i + 1] != '*') {
                            if (s[i + 1] <= '6') {
                                dp[i] += dp[i + 2] * 2;
                            } else {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            dp[i] += dp[i + 2] * 15;
                        }
                    }
                }
                dp[i] %= mod;
            }
        }
        return (int) dp[0];
    }

    public static int numDecodings4(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        long cur = 0, next = 1, nextNext = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] != '0') {
                cur = (s[i] == '*' ? 9 : 1) * next;
                if (i + 1 < n) {
                    if (s[i] != '*') {
                        if (s[i + 1] != '*') {
                            if ((s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                                cur += nextNext;
                            }
                        } else {
                            if (s[i] == '1') {
                                cur += nextNext * 9;
                            }
                            if (s[i] == '2') {
                                cur += nextNext * 6;
                            }
                        }
                    } else {
                        if (s[i + 1] != '*') {
                            if (s[i + 1] <= '6') {
                                cur += nextNext * 2;
                            } else {
                                cur += nextNext;
                            }
                        } else {
                            cur += nextNext * 15;
                        }
                    }
                }
                cur %= mod;
            }
            nextNext = next;
            next = cur;
            cur = 0;
        }
        return (int) next;
    }
}
