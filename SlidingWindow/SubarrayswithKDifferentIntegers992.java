package SlidingWindow;

import java.util.Arrays;

public class SubarrayswithKDifferentIntegers992 {
    public static int subarraysWithKDistinct(int[] arr, int k) {
        return numsOfMostKinds(arr, k) - numsOfMostKinds(arr, k - 1);
    }

    public static int MAXN = 20001;

    public static int[] cnts = new int[MAXN];

    // arr中有多少子数组，数字种类不超过k
    // arr的长度是n，arr里的数值1~n之间
    public static int numsOfMostKinds(int[] arr, int k) {
        Arrays.fill(cnts, 1, arr.length + 1, 0);
        int ans = 0;
        for (int l = 0, r = 0, collect = 0; r < arr.length; r++) {
            if (++cnts[arr[r]] == 1) {
                collect++;
            }
            while (collect > k) {
                if (--cnts[arr[l++]] == 0) {
                    collect--;
                }
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
