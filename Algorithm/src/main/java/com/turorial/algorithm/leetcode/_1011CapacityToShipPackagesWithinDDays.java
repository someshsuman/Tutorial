package com.turorial.algorithm.leetcode;

/** https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/ */
public class _1011CapacityToShipPackagesWithinDDays {
  public int shipWithinDays(int[] weights, int D) {

    int totalWeight = 0;
    int maxDays = 0;
    for (int i = 0; i < weights.length; i++) {
      totalWeight += weights[i];
      maxDays = Math.max(maxDays, weights[i]);
    }

    int low = maxDays, high = totalWeight;

    while (low <= high) {
      if (low == high) {
        return low;
      }

      int mid = low + (high - low) / 2;
      int days = isCapacityValid(mid, weights);
      // System.out.println("mid="+mid+" days="+days+" totalWeight="+totalWeight+" low="+low+"
      // high="+high);
      if (days == D) {
        high = mid;
      } else if (days < D) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public int isCapacityValid(int mid, int[] weight) {
    int days = 1;
    int sum = 0;
    for (int i = 0; i < weight.length; i++) {
      sum += weight[i];
      if (sum > mid) {
        sum = weight[i];
        days += 1;
      }
    }
    return days;
  }
}
