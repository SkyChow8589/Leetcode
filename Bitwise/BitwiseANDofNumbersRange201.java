package Bitwise;

public class BitwiseANDofNumbersRange201 {
    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right -= right & -right;
        }
        return right;
    }
}
