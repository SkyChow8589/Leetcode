package Binary_Search;

public class KokoEatingBananas875 {
    // 时间复杂度O(n * log(max))，额外空间复杂度O(1)
    public static int minEatingSpeed(int[] piles, int h) {
        // 最小且达标的速度，范围[l,r]
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        // [l,r]不停二分
        int ans = 0;
        int m = 0;
        while (l <= r) {
            // m = (l + r) / 2
            m = l + ((r - l) >> 1);
            if (f(piles, m) <= h) {
                // 达标！
                // 记录答案，去左侧二分
                ans = m;
                // l....m....r
                // l..m-1
                r = m - 1;
            } else {
                // 不达标
                l = m + 1;
            }
        }
        return ans;
    }

    // 香蕉重量都在piles
    // 速度就定成speed
    // 返回吃完所有的香蕉，耗费的小时数量
    public static long f(int[] piles, int speed) {
        long ans = 0;
        for (int pile : piles) {
            // (a/b)结果向上取整，如果a和b都是非负数，可以写成(a+b-1)/b
            // "讲解032-位图"讲了这种写法，不会的同学可以去看看
            // 这里不再赘述
            ans += (pile + speed - 1) / speed;
        }
        return ans;
    }
}
