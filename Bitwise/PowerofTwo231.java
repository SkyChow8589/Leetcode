package Bitwise;

public class PowerofTwo231 {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && n == (n & -n);
    }
}
