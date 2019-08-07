package com.turorial.algorithm.leetcode;

/** https://leetcode.com/problems/find-bottom-left-tree-value/ */
public class _513FindBottomLeftTreeValue {
  int maxDepth = -1;
  int value = 0;

  public int findBottomLeftValue(TreeNode root) {
    preOrder(root, 0);
    return value;
  }

  public void preOrder(TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    if (maxDepth < depth) {
      maxDepth = depth;
      value = root.val;
    }
    preOrder(root.left, depth + 1);
    preOrder(root.right, depth + 1);
  }
}
