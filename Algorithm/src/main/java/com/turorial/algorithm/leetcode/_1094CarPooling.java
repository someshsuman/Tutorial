package com.turorial.algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/** https://leetcode.com/problems/car-pooling/ */
public class _1094CarPooling {

  public boolean anothercarPooling(int[][] trips, int capacity) {

    Arrays.sort(trips, (o1, o2) -> Integer.compare(o1[1], o2[1]));

    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));

    int cap = 0;
    for (int[] trip : trips) {
      while (!queue.isEmpty() && trip[1] >= queue.peek()[2]) {
        int[] tempTrip = queue.poll();
        cap = cap - tempTrip[0];
      }
      cap += trip[0];
      queue.add(trip);
      if (cap > capacity) {
        return false;
      }
    }
    return true;
  }

  public boolean carPooling(int[][] trips, int capacity) {

    int[] stop = new int[1001];

    for (int[] trip : trips) {
      stop[trip[1]] += trip[0];
      stop[trip[2]] -= trip[0];
    }

    for (int i = 0; i < 1001; i++) {
      capacity -= stop[i];
      if (capacity < 0) {
        return false;
      }
    }

    return true;
  }
}
