/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading;

import java.util.Random;

class MyThread implements Runnable {
   private Thread t;
   final private int threadnum;
   final private String threadname;
   
   public int RandInt(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min) + min;
   }
   
   MyThread( int id, String threadname) {
      this.threadnum = id;
      this.threadname = threadname;
      System.out.println("Creating " + this.threadnum );
   }
   
   public void run() {
      System.out.println("Running " +  this.threadnum );
      try {
         for(int i = 0; i < 5; ++i) {
            int val = this.threadnum + i;
            System.out.println("Thread: " + this.threadname + ": " + val);
            int time = RandInt(500, 3000);
            Thread.sleep(time);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  this.threadname + " interrupted.");
      }
      System.out.println("Thread " +  this.threadname + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  this.threadnum );
      if (t == null) {
         t = new Thread (this, this.threadname);
         t.start ();
      }
   }
}
