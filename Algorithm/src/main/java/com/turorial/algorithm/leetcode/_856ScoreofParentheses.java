package com.turorial.algorithm.leetcode;

import java.util.Stack;

/** https://leetcode.com/problems/score-of-parentheses/ */
public class _856ScoreofParentheses {

  public int scoreOfParentheses(String S) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if (ch == '(') {
        stack.push(-1);
      }

      if (ch == ')') {
        int count = 0;
        while (stack.peek() != -1) {
          count += stack.pop();
        }
        stack.pop();
        int tempCount = count > 0 ? 2 * count : 1;
        stack.push(tempCount);
      }
    }
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }
}
