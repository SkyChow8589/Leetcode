package Palindrome;

public class PalindromeNumber9 {
    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        int offset = 1;
        // 注意这么写是为了防止溢出
        while (num / offset >= 10) {
            offset *= 10;
        }
        // 首尾判断
        while (num != 0) {
            if (num / offset != num % 10) {
                return false;
            }
            num = (num % offset) / 10;
            offset /= 100;
        }
        return true;
    }
}
