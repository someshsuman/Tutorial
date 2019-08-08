package com.turorial.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/longest-common-subsequence/ */
public class _1143LongestCommonSubsequence {

  public int longestCommonSubsequence(String text1, String text2) {

    Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
    return common(text1, 0, text2, 0, memo);
  }

  public int common(
      String text1,
      int start1,
      String text2,
      int start2,
      Map<Integer, Map<Integer, Integer>> memo) {

    if (start1 == text1.length() || start2 == text2.length()) {
      return 0;
    }

    if (memo.containsKey(start1) && memo.get(start1).containsKey(start2)) {
      return memo.get(start1).get(start2);
    }

    int result = 0;
    if (text1.charAt(start1) == text2.charAt(start2)) {
      result = common(text1, start1 + 1, text2, start2 + 1, memo) + 1;
    } else {
      int long1 = common(text1, start1 + 1, text2, start2, memo);
      int long2 = common(text1, start1, text2, start2 + 1, memo);
      result = Math.max(long1, long2);
    }

    if (!memo.containsKey(start1)) {
      memo.put(start1, new HashMap<>());
    }
    memo.get(start1).put(start2, result);

    return result;
  }
}
