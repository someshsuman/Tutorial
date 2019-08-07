package com.turorial.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/generate-parentheses/ */
public class _22GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();
    paran(result, new StringBuilder(), n, n);
    return result;
  }

  public void paran(List<String> result, StringBuilder sb, int left, int right) {
    if (left == 0 && right == 0) {
      result.add(sb.toString());
    }

    if (left > 0) {
      sb.append("(");
      paran(result, sb, left - 1, right);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (right > left) {
      sb.append(")");
      paran(result, sb, left, right - 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
