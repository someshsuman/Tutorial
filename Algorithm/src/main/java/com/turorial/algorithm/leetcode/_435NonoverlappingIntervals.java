package com.turorial.algorithm.leetcode;

import java.util.Arrays;

/** https://leetcode.com/problems/non-overlapping-intervals/ */
public class _435NonoverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    Arrays.sort(
        intervals,
        (o1, o2) -> {
          if (Integer.compare(o1[0], o2[0]) == 0) {
            return Integer.compare(o1[1], o2[1]);
          } else {
            return Integer.compare(o1[0], o2[0]);
          }
        });

    int[] currInterval = intervals[0];
    int overlap = 0;
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (isOverlapping(currInterval, interval)) {
        // System.out.println("Overlapping found currInterval.start="+currInterval[0]+"
        // currInterval.end="+currInterval[1]+" interval.start="+interval[0]+"
        // interval[1]="+interval[1]);
        currInterval[1] = Math.min(currInterval[1], interval[1]);
        overlap++;
      } else {
        currInterval = interval;
      }
    }
    return overlap;
  }

  public boolean isOverlapping(int[] a, int[] b) {
    return a[0] < b[1] && a[1] > b[0];
  }
}
