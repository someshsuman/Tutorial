package com.turorial.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/permutations/ */
public class _46Permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    permute(nums, used, temp, result);
    return result;
  }

  public void permute(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> result) {
    if (temp.size() == nums.length) {
      result.add(new ArrayList<>(temp));
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i] == true) continue;
      used[i] = true;
      temp.add(nums[i]);
      permute(nums, used, temp, result);
      temp.remove(temp.size() - 1);
      used[i] = false;
    }
  }
}
