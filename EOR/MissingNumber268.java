package EOR;

public class MissingNumber268 {
    int eorAll = 0, eorHas = 0;
    for (int i = 0; i < nums.length; i++) {
    eorAll ^= i;
    eorHas ^= nums[i];
    }
    eorAll ^= nums.length;
    return eorAll ^ eorHas;

}
