package com.turorial.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/find-largest-value-in-each-tree-row/ */
public class _515FindLargestValueinEachTreeRow {
  public List<Integer> largestValues(TreeNode root) {
    int depth = 0;
    List<Integer> result = new ArrayList<>();
    preOrder(root, result, 0);
    return result;
  }

  public void preOrder(TreeNode root, List<Integer> result, int depth) {
    if (root == null) {
      return;
    }

    if (result.size() < depth + 1) {
      result.add(root.val);
    }

    if (result.get(depth) < root.val) {
      result.set(depth, root.val);
    }

    preOrder(root.left, result, depth + 1);
    preOrder(root.right, result, depth + 1);
  }
}
