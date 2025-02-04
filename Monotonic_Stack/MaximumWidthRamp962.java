package Monotonic_Stack;

public class MaximumWidthRamp962 {
    public static int MAXN = 50001;

    public static int[] stack = new int[MAXN];

    public static int r;

    public static int maxWidthRamp(int[] arr) {
        // 令r=1相当于0位置进栈了
        // stack[0] = 0，然后栈的大小变成1
        r = 1;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[stack[r - 1]] > arr[i]) {
                stack[r++] = i;
            }
        }
        int ans = 0;
        for (int j = n - 1; j >= 0; j--) {
            while (r > 0 && arr[stack[r - 1]] <= arr[j]) {
                ans = Math.max(ans, j - stack[--r]);
            }
        }
        return ans;
    }
}
