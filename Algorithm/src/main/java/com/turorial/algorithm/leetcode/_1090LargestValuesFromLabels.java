package com.turorial.algorithm.leetcode;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/** https://leetcode.com/problems/largest-values-from-labels/ */
public class _1090LargestValuesFromLabels {
  public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

    for (int i = 0; i < labels.length; i++) {
      if (!map.containsKey(labels[i])) {
        map.put(labels[i], new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1)));
      }
      map.get(labels[i]).add(values[i]);
    }

    Map<Integer, Integer> counter = new HashMap<>();

    PriorityQueue<Map.Entry<Integer, Integer>> queue =
        new PriorityQueue<>((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

    for (int key : map.keySet()) {
      int value = map.get(key).poll();
      Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleImmutableEntry<>(key, value);
      queue.add(entry);
      counter.put(key, 1);
    }

    int result = 0;
    while (num_wanted > 0 && queue.size() > 0) {
      Map.Entry<Integer, Integer> entry = queue.poll();
      result += entry.getValue();

      int key = entry.getKey();
      if (map.get(key).size() > 0 && counter.get(key) < use_limit) {
        Map.Entry<Integer, Integer> tempEntry =
            new AbstractMap.SimpleImmutableEntry<>(key, map.get(key).poll());
        queue.add(tempEntry);
        counter.put(key, counter.get(key) + 1);
      }
      num_wanted -= 1;
    }
    return result;
  }
}
