package Double_Pointer;

public class ContainerWithMostWater11 {
    // 时间复杂度O(n)，额外空间复杂度O(1)
    public static int maxArea(int[] height) {
        int ans = 0;
        for (int l = 0, r = height.length - 1; l < r;) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
