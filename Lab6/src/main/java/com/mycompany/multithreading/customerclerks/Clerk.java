/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading.customerclerks;
import java.util.concurrent.TimeUnit;

public class Clerk extends MyThreadAnchor {
    final private Queue ref_to_queue;
    public Clerk( Queue ref_to_queue) { this.ref_to_queue = ref_to_queue; }
    
    @Override public void Run() throws Exception
    {
        while(true)
        {
            Customer obj = this.ref_to_queue.pop();
            if(obj != null)
            {
                TimeUnit.MILLISECONDS.sleep((long)obj.GetTime()*1000);
            }
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
