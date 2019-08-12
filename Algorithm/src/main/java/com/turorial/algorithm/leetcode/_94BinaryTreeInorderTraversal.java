package com.turorial.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** https://leetcode.com/problems/binary-tree-inorder-traversal/ */
public class _94BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();
    while (!stack.isEmpty() || root != null) {
      if (root != null) {
        // System.out.println("pushing root="+root.val);
        stack.push(root);
        root = root.left;

      } else {
        TreeNode temp = stack.pop();
        // System.out.println("temp=" + temp);
        result.add(temp.val);
        if (temp.right != null) {
          root = temp.right;
        }
      }
    }

    return result;
  }
}
