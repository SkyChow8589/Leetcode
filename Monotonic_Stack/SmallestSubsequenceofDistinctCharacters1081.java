package Monotonic_Stack;

public class SmallestSubsequenceofDistinctCharacters1081 {
    public static int MAXN = 26;

    // 每种字符词频
    public static int[] cnts = new int[MAXN];

    // 每种字符目前有没有进栈
    public static boolean[] enter = new boolean[MAXN];

    // 单调栈
    public static char[] stack = new char[MAXN];

    public static int r;

    public String smallestSubsequence(String str) {
        r = 0;
        Arrays.fill(cnts, 0);
        Arrays.fill(enter, false);
        char[] s = str.toCharArray();
        for (char cha : s) {
            cnts[cha - 'a']++;
        }
        for (char cur : s) {
            if (!enter[cur - 'a']) {
                while (r > 0 && stack[r - 1] > cur && cnts[stack[r - 1] - 'a'] > 0) {
                    enter[stack[r - 1] - 'a'] = false;
                    r--;
                }
                stack[r++] = cur;
                enter[cur - 'a'] = true;
            }
            cnts[cur - 'a']--;
        }
        return String.valueOf(stack, 0, r);
    }
}
