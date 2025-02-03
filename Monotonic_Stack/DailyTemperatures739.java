package Monotonic_Stack;

public class DailyTemperatures739 {
    public static int MAXN = 100001;

    public static int[] stack = new int[MAXN];

    public static int r;

    public static int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        r = 0;
        for (int i = 0, cur; i < n; i++) {
            // 相等时候的处理，相等也加入单调栈
            while (r > 0 && nums[stack[r - 1]] < nums[i]) {
                cur = stack[--r];
                ans[cur] = i - cur;
            }
            stack[r++] = i;
        }
        return ans;
    }
}
