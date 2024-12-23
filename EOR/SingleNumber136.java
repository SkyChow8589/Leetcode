package EOR;

public class SingleNumber136 {
    public static int singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        return eor;
    }
}
