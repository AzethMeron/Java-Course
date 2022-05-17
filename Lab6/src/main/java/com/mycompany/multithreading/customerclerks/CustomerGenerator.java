/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading.customerclerks;
import java.lang.Math;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author meron
 */

class RandomExp
{
    final private double lambda;
    final private Random generator = new Random();
    RandomExp(double lambda) { this.lambda = lambda; }
    public double get()
    {
        double u = this.generator.nextDouble();
        return Math.log(1-u) / (-this.lambda);
    }
}

public class CustomerGenerator extends MyThreadAnchor {
    final private RandomExp generator = new RandomExp(1.5); // lambda - given in seconds
    final private Queue ref_to_queue;
    public CustomerGenerator(Queue ref_to_queue) { this.ref_to_queue = ref_to_queue; }
    @Override public void Run() throws Exception
    {
        while(true)
        {
            long time = (long)this.generator.get() * 1000;
            TimeUnit.MILLISECONDS.sleep(time);
            this.ref_to_queue.push(new Customer());
        }
    }
}
