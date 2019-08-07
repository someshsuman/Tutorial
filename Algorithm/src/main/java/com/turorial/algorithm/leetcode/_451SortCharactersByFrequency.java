package com.turorial.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** https://leetcode.com/problems/sort-characters-by-frequency/ */
public class _451SortCharactersByFrequency {
  public String frequencySort(String s) {
    Map<Character, Integer> count = new HashMap<>();
    int maxCount = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      count.put(ch, count.getOrDefault(ch, 0) + 1);
      maxCount = Math.max(maxCount, count.get(ch));
    }

    List<Character>[] chList = new List[maxCount + 1];
    for (Map.Entry<Character, Integer> entry : count.entrySet()) {
      int countValue = entry.getValue();
      System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
      if (chList[countValue] == null) {
        chList[countValue] = new ArrayList<>();
      }
      chList[countValue].add(entry.getKey());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = chList.length - 1; i >= 0; i--) {
      List<Character> temp = chList[i];
      if (temp == null) continue;
      for (int j = 0; j < temp.size(); j++) {
        for (int a = 0; a < i; a++) sb.append(temp.get(j));
      }
    }

    return sb.toString();
  }
}
