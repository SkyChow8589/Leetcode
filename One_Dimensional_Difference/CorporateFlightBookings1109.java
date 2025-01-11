package One_Dimensional_Difference;

public class CorporateFlightBookings1109 {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] cnt = new int[n + 2];
        // 设置差分数组，每一个操作对应两个设置
        for (int[] book : bookings) {
            cnt[book[0]] += book[2];
            cnt[book[1] + 1] -= book[2];
        }
        // 加工前缀和
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = cnt[i + 1];
        }
        return ans;
    }
}
