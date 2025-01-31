package Double_Pointer;

public class FindtheDuplicateNumber287 {
    // 时间复杂度O(n)，额外空间复杂度O(1)
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 相遇了，快指针回开头
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
