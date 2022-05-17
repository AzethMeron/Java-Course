/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading.customerclerks;

/**
 *
 * @author meron
 */
import java.util.concurrent.*;

public class Queue {
    final private ConcurrentLinkedQueue<Customer> queue = new ConcurrentLinkedQueue<>();
    final int limit;
    
    int serviced = 0;
    int rejected = 0;
    int received = 0;
    
    public Queue(int limit) { this.limit = limit; }
    
    public boolean push(Customer ob) { 
        if( this.queue.size() < this.limit)
        {
            this.received = this.received + 1;
            this.queue.add(ob); 
            return true;
        }
        else
        {
            this.rejected = this.rejected + 1;
            return false;
        }
    }
    
    public Customer pop() 
    { 
        Customer out = this.queue.poll();
        if(out != null)
        { this.serviced = this.serviced + 1; }
        return out;
    }
    
    @Override public String toString()
    {
        return String.format("Serviced %d Waiting %d Rejected %d", this.serviced, this.received - this.serviced, this.rejected);
    }
}
