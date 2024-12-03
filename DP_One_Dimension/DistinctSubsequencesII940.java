package DP_One_Dimension;

public class DistinctSubsequencesII940 {
    // 时间复杂度O(n)，n是字符串s的长度
    public static int distinctSubseqII(String s) {
        int mod = 1000000007;
        char[] str = s.toCharArray();
        int[] cnt = new int[26];
        int all = 1, newAdd;
        for (char x : str) {
            newAdd = (all - cnt[x - 'a'] + mod) % mod;
            cnt[x - 'a'] = (cnt[x - 'a'] + newAdd) % mod;
            all = (all + newAdd) % mod;
        }
        return (all - 1 + mod) % mod;
    }
}
