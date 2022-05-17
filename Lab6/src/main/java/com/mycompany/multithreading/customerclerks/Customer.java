/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading.customerclerks;
import java.util.Random;

class RandomGaussian
{
    final private double mean;
    final private double deviation;
    final private Random generator = new Random();
    public RandomGaussian(double mean, double deviation)
    {
        this.mean = mean;
        this.deviation = deviation;
    }
    public double next()
    { return this.mean + this.generator.nextGaussian()*this.deviation; }
}

public class Customer {
    
    private double time = 0; // given in seconds
    final private RandomGaussian generator = new RandomGaussian(0.15, 0.05); // mean, deviation given in seconds
    Customer() { this.time = this.generator.next(); }
    double GetTime() { return this.time; }
}
