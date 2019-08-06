package com.turorial.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/** https://leetcode.com/problems/max-consecutive-ones-iii/ */
public class _1004MaxConsecutiveOnesIII {

  public int longestOnes(int[] A, int K) {
    return withoutQueue(A, K);
  }

  public int withQueue(int[] A, int k) {
    int maxResult = 0;
    int j = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        queue.add(i);
      }
      if (queue.size() > k) {
        j = queue.poll() + 1;
      }

      maxResult = Math.max(maxResult, i - j + 1);
    }
    return maxResult;
  }

  public int withoutQueue(int[] A, int k) {
    int maxResult = 0;
    int zeroCount = 0;
    int j = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        zeroCount++;
      }
      while (zeroCount > k) {
        if (A[j] == 0) {
          zeroCount--;
        }
        j += 1;
      }

      maxResult = Math.max(maxResult, i - j + 1);
      // System.out.println("i="+i+" j="+j+" maxResult="+maxResult);
    }
    return maxResult;
  }
}
