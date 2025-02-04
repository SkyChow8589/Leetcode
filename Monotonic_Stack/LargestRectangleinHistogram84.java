package Monotonic_Stack;

public class LargestRectangleinHistogram84 {
    public static int MAXN = 100001;

    public static int[] stack = new int[MAXN];

    public static int r;

    public static int largestRectangleArea(int[] height) {
        int n = height.length;
        r = 0;
        int ans = 0, cur, left;
        for (int i = 0; i < n; i++) {
            // i -> arr[i]
            while (r > 0 && height[stack[r - 1]] >= height[i]) {
                cur = stack[--r];
                left = r == 0 ? -1 : stack[r - 1];
                ans = Math.max(ans, height[cur] * (i - left - 1));
            }
            stack[r++] = i;
        }
        while (r > 0) {
            cur = stack[--r];
            left = r == 0 ? -1 : stack[r - 1];
            ans = Math.max(ans, height[cur] * (n - left - 1));
        }
        return ans;
    }
}
