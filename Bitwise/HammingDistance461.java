package Bitwise;

public class HammingDistance461 {
    public static int hammingDistance(int x, int y) {
        return cntOnes(x ^ y);
    }

    // 返回n的二进制中有几个1
    // 这个实现脑洞太大了
    public static int cntOnes(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }
}
