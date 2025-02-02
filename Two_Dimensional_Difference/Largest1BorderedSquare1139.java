package Two_Dimensional_Difference;

public class Largest1BorderedSquare1139 {
    // 打败比例不高，但完全是常数时间的问题
    // 时间复杂度O(n * m * min(n,m))，额外空间复杂度O(1)
    // 复杂度指标上绝对是最优解
    public static int largest1BorderedSquare(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        build(n, m, g);
        if (sum(g, 0, 0, n - 1, m - 1) == 0) {
            return 0;
        }
        // 找到的最大合法正方形的边长
        int ans = 1;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                // (a,b)所有左上角点
                //     (c,d)更大边长的右下角点，k是当前尝试的边长
                for (int c = a + ans, d = b + ans, k = ans + 1; c < n && d < m; c++, d++, k++) {
                    if (sum(g, a, b, c, d) - sum(g, a + 1, b + 1, c - 1, d - 1) == (k - 1) << 2) {
                        ans = k;
                    }
                }
            }
        }
        return ans * ans;
    }

    // g : 原始二维数组
    // 把g变成原始二维数组的前缀和数组sum，复用自己
    // 不能补0行，0列，都是0
    public static void build(int n, int m, int[][] g) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] += get(g, i, j - 1) + get(g, i - 1, j) - get(g, i - 1, j - 1);
            }
        }
    }

    public static int sum(int[][] g, int a, int b, int c, int d) {
        return a > c ? 0 : (g[c][d] - get(g, c, b - 1) - get(g, a - 1, d) + get(g, a - 1, b - 1));
    }

    public static int get(int[][] g, int i, int j) {
        return (i < 0 || j < 0) ? 0 : g[i][j];
    }

}
