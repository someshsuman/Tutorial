package com.turorial.algorithm.leetcode;

/** https://leetcode.com/problems/print-foobar-alternately/ */
public class _1115PrintFooBarAlternately {
  private int n;

  public _1115PrintFooBarAlternately(int n) {
    this.n = n;
  }

  boolean isFoo = true;

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; ) {

      // printFoo.run() outputs "foo". Do not change or remove this line.
      synchronized (this) {
        if (isFoo) {
          // System.out.println("processing foo");
          printFoo.run();
          isFoo = false;
          notifyAll();
          i++;
        } else {
          // System.out.println("waiting in  foo");
          wait();
        }
      }
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; ) {

      // printBar.run() outputs "bar". Do not change or remove this line.
      synchronized (this) {
        if (!isFoo) {
          // System.out.println("processing bar");
          printBar.run();
          isFoo = true;
          notifyAll();
          i++;
        } else {
          // System.out.println("waiting in bar");
          wait();
        }
      }
    }
  }
}
