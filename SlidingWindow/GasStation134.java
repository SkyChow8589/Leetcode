package SlidingWindow;

public class GasStation134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // 本来下标是0..n-1，但是扩充到0..2*n-1，i位置的余量信息在(r%n)位置
        // 窗口范围是[l, r)，左闭右开，也就是说窗口是[l..r-1]，r是到不了的位置
        for (int l = 0, r = 0, sum; l < n; l = r + 1, r = l) {
            sum = 0;
            while (sum + gas[r % n] - cost[r % n] >= 0) {
                // r位置即将右扩，窗口会变大
                if (r - l + 1 == n) { // 此时检查是否已经转了一圈
                    return l;
                }
                // r位置进入窗口，累加和加上r位置的余量
                sum += gas[r % n] - cost[r % n];
                // r右扩，窗口变大了
                r++;
            }
        }
        return -1;
    }
}
