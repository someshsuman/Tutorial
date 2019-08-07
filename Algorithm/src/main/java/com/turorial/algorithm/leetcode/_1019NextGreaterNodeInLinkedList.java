package com.turorial.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** https://leetcode.com/problems/next-greater-node-in-linked-list/ */
public class _1019NextGreaterNodeInLinkedList {
  public static int[] nextLargerNodes(ListNode head) {

    Stack<Integer> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();
    ListNode root = head;
    int index = 0;
    while (root != null) {
      int value = root.val;
      result.add(value);
      if (stack.isEmpty() || result.get(stack.peek()) >= value) {
        stack.push(index);
      } else {

        while (!stack.isEmpty() && result.get(stack.peek()) < value) {
          int tempindex = stack.pop();
          result.set(tempindex, value);
        }
        stack.push(index);
      }
      index++;
      root = root.next;
    }

    while (!stack.isEmpty()) {
      result.set(stack.pop(), 0);
    }

    int[] finalResult = new int[result.size()];
    System.out.println(result);
    for (int i = 0; i < finalResult.length; i++) {
      finalResult[i] = result.get(i);
    }

    return finalResult;
  }
}
