package com.turorial.algorithm.leetcode;

public class _983MinimumCostForTickets {
  public int mincostTickets(int[] days, int[] costs) {
    int[] dp = new int[30];
    int index = 0;
    for (int i = days[0]; i <= days[days.length - 1]; i++) {
      if (i != days[index]) {
        dp[i % 30] = dp[Math.max(0, i - 1) % 30];
      } else {
        dp[i % 30] =
            Math.min(
                dp[Math.max(0, (i - 1)) % 30] + costs[0],
                Math.min(
                    dp[Math.max(0, (i - 7)) % 30] + costs[1],
                    dp[Math.max(0, (i - 30)) % 30] + costs[2]));
        // System.out.println("i="+i+" (i%30)="+(i%30)+" dp[i%30]="+dp[i%30]);
        index++;
      }
    }
    return dp[days[days.length - 1] % 30];
  }
}
