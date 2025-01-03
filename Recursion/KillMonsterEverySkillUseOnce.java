package Recursion;

import java.io.*;

public class KillMonsterEverySkillUseOnce {
    public static int MAXN = 11;

    public static int[] kill = new int[MAXN];

    public static int[] blood = new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int t = (int) in.nval;
            for (int i = 0; i < t; i++) {
                in.nextToken();
                int n = (int) in.nval;
                in.nextToken();
                int m = (int) in.nval;
                for (int j = 0; j < n; j++) {
                    in.nextToken();
                    kill[j] = (int) in.nval;
                    in.nextToken();
                    blood[j] = (int) in.nval;
                }
                int ans = f(n, 0, m);
                out.println(ans == Integer.MAX_VALUE ? -1 : ans);
            }
        }
        out.flush();
        br.close();
        out.close();
    }

    // kill[i]、blood[i]
    // n : 一共几个技能
    // i : 当前来到了第几号技能
    // r : 怪兽目前的剩余血量
    public static int f(int n, int i, int r) {
        if (r <= 0) {
            // 之前的决策已经让怪兽挂了！返回使用了多少个节能
            return i;
        }
        // r > 0
        if (i == n) {
            // 无效，之前的决策无效
            return Integer.MAX_VALUE;
        }
        // 返回至少需要几个技能可以将怪兽杀死
        int ans = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            swap(i, j);
            ans = Math.min(ans, f(n, i + 1, r - (r > blood[i] ? kill[i] : kill[i] * 2)));
            swap(i, j);
        }
        return ans;
    }

    // i号技能和j号技能，参数交换
    // j号技能要来到i位置，试一下
    public static void swap(int i, int j) {
        int tmp = kill[i];
        kill[i] = kill[j];
        kill[j] = tmp;
        tmp = blood[i];
        blood[i] = blood[j];
        blood[j] = tmp;
    }
}
