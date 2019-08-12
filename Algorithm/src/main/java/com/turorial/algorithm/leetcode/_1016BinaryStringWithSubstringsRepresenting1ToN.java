package com.turorial.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _1016BinaryStringWithSubstringsRepresenting1ToN {
  public static boolean queryString(String S, int N) {

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '0') {
        continue;
      }
      int num = 0;
      for (int j = i; i - j < 32 && j < S.length(); j++) {
        char ch = S.charAt(j);
        num = (num << 1) + ch - '0';
        System.out.println("ch=" + ch + " num=" + num + " i=" + i + " j=" + j);
        if (num >= 1 && num <= N) {
          set.add(num);
          System.out.println("Adding num=" + num + " into set size()-" + set.size());
        }
      }
    }

    return set.size() == N;
  }

  public static void main(String[] args) {
    String inputS =
        "11100000011101000000101010000100001001100000000101100011101101010100011010101100010010001001100101100011011110101011000110011011101110000111100001111111000101011110110101110110101001011010100110001001";
    int inputN = 10;
    queryString(inputS, inputN);
  }
}
