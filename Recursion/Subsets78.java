package Recursion;

public class Subsets78 {
    private List<List<Integer>> output = new ArrayList();
    private int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) output.add(new ArrayList(curr));
        for (int i = first; i < n; ++i) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            ArrayList<Integer> currCombo = new ArrayList<Integer>();
            backtrack(0, currCombo, nums);
        }
        return output;
    }
}
