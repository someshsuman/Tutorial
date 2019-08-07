package com.turorial.algorithm.leetcode;

/** https://leetcode.com/problems/minimum-falling-path-sum/ */
public class _931MinimumFallingPathSum {
  public int minFallingPathSum(int[][] A) {
    for (int i = 1; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        A[i][j] +=
            Math.min(
                A[i - 1][j],
                Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(j + 1, A.length - 1)]));
      }
    }

    int result = Integer.MAX_VALUE;

    for (int i = 0; i < A[0].length; i++) {
      result = Math.min(result, A[A.length - 1][i]);
    }

    return result;
  }
}
