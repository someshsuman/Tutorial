package com.turorial.algorithm.leetcode;

import java.util.Stack;

/** https://leetcode.com/problems/validate-stack-sequences/ */
public class _946ValidateStackSequences {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    int j = 0;
    while (i < pushed.length) {

      stack.push(pushed[i]);

      while (j < popped.length && !stack.isEmpty() && popped[j] == stack.peek()) {
        stack.pop();
        j++;
      }
      i++;
    }

    return stack.isEmpty();
  }
}
