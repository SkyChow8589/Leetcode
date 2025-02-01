package Double_Pointer;

import java.util.Arrays;

public class BoatstoSavePeople881 {
    // 时间复杂度O(n * logn)，因为有排序，额外空间复杂度O(1)
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int l = 0;
        int r = people.length - 1;
        int sum = 0;
        while (l <= r) {
            sum = l == r ? people[l] : people[l] + people[r];
            if (sum > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            ans++;
        }
        return ans;
    }
}
