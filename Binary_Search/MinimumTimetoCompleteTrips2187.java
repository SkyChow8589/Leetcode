package Binary_Search;

public class MinimumTimetoCompleteTrips2187 {
    public static long minimumTime(int[] arr, int w) {
        int min = Integer.MAX_VALUE;
        for (int x : arr) {
            min = Math.min(min, x);
        }
        long ans = 0;
        for (long l = 0, r = (long) min * w, m; l <= r;) {
            m = l + ((r - l) >> 1);
            // 这里逻辑和课上讲的不同
            // 课上讲的题意，是需要等多少人才能获得服务，你是第w+1个
            // 在线测试的题意，是需要完成w趟旅行
            if (f(arr, m) >= w) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static long f(int[] arr, long time) {
        long ans = 0;
        for (int num : arr) {
            // 这里逻辑和课上讲的不同
            // 课上讲的题意，计算time时间内，(完成 + 开始)服务的人数，需要+1
            // 在线测试的题意，计算time时间内，能完成多少旅行，不需要+1
            ans += (time / num);
        }
        return ans;
    }
}
