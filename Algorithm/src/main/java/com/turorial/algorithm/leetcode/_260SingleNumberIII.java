package com.turorial.algorithm.leetcode;

/** https://leetcode.com/problems/single-number-iii/ */
public class _260SingleNumberIII {
  public int[] singleNumber(int[] nums) {

    int xored = 0;

    for (int i = 0; i < nums.length; i++) {
      xored ^= nums[i];
    }

    int setbit = Integer.lowestOneBit(xored);
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      // System.out.println("if condition nums[i]="+nums[i]+"setbit="+setbit+" and
      // operation="+(nums[i] & setbit));
      if ((nums[i] & setbit) != 0) {
        result[0] ^= nums[i];
      } else {
        result[1] ^= nums[i];
      }
    }
    return result;
  }
}
