package com.turorial.algorithm.leetcode;

/** https://leetcode.com/problems/arithmetic-slices/ */
public class _413ArithmeticSlices {
  public int numberOfArithmeticSlices(int[] A) {

    int result = 0;
    int count = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
        count += 1;
        result += count;
      } else {
        count = 0;
      }
    }

    return result;
  }
}
