/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading.customerclerks;

/**
 *
 * @author meron
 */
public class MyThread implements Runnable {
    final private Thread t;
    final MyThreadAnchor obj;
    
    public MyThread(MyThreadAnchor obj)
    {
        this.obj = obj;
        this.t = new Thread(this);
        this.t.start();
    }
    
    @Override public void run()
    {
        try { this.obj.Run(); }
        catch (Exception e) {
         System.out.println("Thread interrupted: " + e);
      }
    }
    
    public void join() throws Exception
    {
        this.t.join();
    }
}
