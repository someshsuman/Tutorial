package com.turorial.algorithm.leetcode;

import java.util.AbstractMap;
import java.util.Map;

/** https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/ */
public class _865SmallestSubtreewithalltheDeepestNodes {
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return deepestNode(root).getValue();
  }

  public Map.Entry<Integer, TreeNode> deepestNode(TreeNode root) {

    if (root == null) {
      return new AbstractMap.SimpleImmutableEntry<>(0, null);
    }

    Map.Entry<Integer, TreeNode> left = deepestNode(root.left);
    Map.Entry<Integer, TreeNode> right = deepestNode(root.right);

    if (left.getKey() == right.getKey()) {
      return new AbstractMap.SimpleImmutableEntry<>(left.getKey() + 1, root);
    }

    int size = Math.max(left.getKey(), right.getKey());
    return new AbstractMap.SimpleImmutableEntry<>(
        size + 1, left.getKey() > right.getKey() ? left.getValue() : right.getValue());
  }
}
