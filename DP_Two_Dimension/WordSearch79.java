package DP_Two_Dimension;

public class WordSearch79 {
    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (f(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 因为board会改其中的字符
    // 用来标记哪些字符无法再用
    // 带路径的递归无法改成动态规划或者说没必要
    // 从(i,j)出发，来到w[k]，请问后续能不能把word走出来w[k...]
    public static boolean f(char[][] b, int i, int j, char[] w, int k) {
        if (k == w.length) {
            return true;
        }
        if (i < 0 || i == b.length || j < 0 || j == b[0].length || b[i][j] != w[k]) {
            return false;
        }
        // 不越界，b[i][j] == w[k]
        char tmp = b[i][j];
        b[i][j] = 0;
        boolean ans = f(b, i - 1, j, w, k + 1)
                || f(b, i + 1, j, w, k + 1)
                || f(b, i, j - 1, w, k + 1)
                || f(b, i, j + 1, w, k + 1);
        b[i][j] = tmp;
        return ans;
    }
}
