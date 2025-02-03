package Monotonic_Stack;

public class SumofSubarrayMinimums907 {
    public static int MOD = 1000000007;

    public static int MAXN = 30001;

    public static int[] stack = new int[MAXN];

    public static int r;

    public static int sumSubarrayMins(int[] arr) {
        long ans = 0;
        r = 0;
        // 注意课上讲的相等情况的修正
        for (int i = 0; i < arr.length; i++) {
            while (r > 0 && arr[stack[r - 1]] >= arr[i]) {
                int cur = stack[--r];
                int left = r == 0 ? -1 : stack[r - 1];
                ans = (ans + (long) (cur - left) * (i - cur) * arr[cur]) % MOD;
            }
            stack[r++] = i;
        }
        while (r > 0) {
            int cur = stack[--r];
            int left = r == 0 ? -1 : stack[r - 1];
            ans = (ans + (long) (cur - left) * (arr.length - cur) * arr[cur]) % MOD;
        }
        return (int) ans;
    }
}
