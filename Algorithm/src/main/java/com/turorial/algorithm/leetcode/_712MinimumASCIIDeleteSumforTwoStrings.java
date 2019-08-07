package com.turorial.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/ */
public class _712MinimumASCIIDeleteSumforTwoStrings {
  public int minimumDeleteSum(String s1, String s2) {
    Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
    return deleteString(s1.toCharArray(), s2.toCharArray(), 0, 0, memo);
  }

  public int deleteString(
      char[] s1, char[] s2, int start1, int start2, Map<Integer, Map<Integer, Integer>> memo) {

    if (start1 == s1.length) {
      return sumAscii(s2, start2);
    }

    if (start2 == s2.length) {
      return sumAscii(s1, start1);
    }

    if (memo.containsKey(start1) && memo.get(start1).containsKey(start2)) {
      // System.out.println("Hitting memo");
      return memo.get(start1).get(start2);
    }
    int result = 0;
    if (s1[start1] == s2[start2]) {
      result = deleteString(s1, s2, start1 + 1, start2 + 1, memo);
    } else {
      int s1delete = s1[start1];
      int s2delete = s2[start2];
      int min1 = deleteString(s1, s2, start1 + 1, start2, memo);
      int min2 = deleteString(s1, s2, start1, start2 + 1, memo);
      result = Math.min(min1 + s1delete, min2 + s2delete);
    }

    if (!memo.containsKey(start1)) {
      memo.put(start1, new HashMap<>());
    }
    memo.get(start1).put(start2, result);
    return result;
  }

  public int sumAscii(char[] s, int start) {
    int result = 0;
    for (int i = start; i < s.length; i++) {
      result += s[i];
    }

    return result;
  }
}
