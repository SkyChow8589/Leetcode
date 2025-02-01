package Double_Pointer;

public class FirstMissingPositive41 {
    // 时间复杂度O(n)，额外空间复杂度O(1)
    public static int firstMissingPositive(int[] arr) {
        // l的左边，都是做到i位置上放着i+1的区域
        // 永远盯着l位置的数字看，看能不能扩充(l++)
        int l = 0;
        // [r....]垃圾区
        // 最好的状况下，认为1~r是可以收集全的，每个数字收集1个，不能有垃圾
        // 有垃圾呢？预期就会变差(r--)
        int r = arr.length;
        while (l < r) {
            if (arr[l] == l + 1) {
                l++;
            } else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
                swap(arr, l, --r);
            } else {
                swap(arr, l, arr[l] - 1);
            }
        }
        return l + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
