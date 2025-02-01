package Double_Pointer;

import java.util.Arrays;

public class Heaters475 {
    // 时间复杂度O(n * logn)，因为有排序，额外空间复杂度O(1)
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            // i号房屋
            // j号供暖器
            while (!best(houses, heaters, i, j)) {
                j++;
            }
            ans = Math.max(ans, Math.abs(heaters[j] - houses[i]));
        }
        return ans;
    }

    // 这个函数含义：
    // 当前的地点houses[i]由heaters[j]来供暖是最优的吗？
    // 当前的地点houses[i]由heaters[j]来供暖，产生的半径是a
    // 当前的地点houses[i]由heaters[j + 1]来供暖，产生的半径是b
    // 如果a < b, 说明是最优，供暖不应该跳下一个位置
    // 如果a >= b, 说明不是最优，应该跳下一个位置
    public static boolean best(int[] houses, int[] heaters, int i, int j) {
        return j == heaters.length - 1
                ||
                Math.abs(heaters[j] - houses[i]) < Math.abs(heaters[j + 1] - houses[i]);
    }
}
