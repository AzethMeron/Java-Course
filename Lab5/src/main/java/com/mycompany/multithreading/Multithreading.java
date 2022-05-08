/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.multithreading;
import java.util.ArrayList;

public class Multithreading {

    public static void main(String[] args) throws Exception
    {
        // Task 1
        ArrayList<MyThread> threads = new ArrayList<>();
        for(int i = 0; i < 5; ++i)
        {
            MyThread e = new MyThread(i,"Thread"+i);
            threads.add(e);
            e.start();
        }
        for(MyThread t : threads)
        {
            t.join();
        }
        
        
        // Task 2
        NumericDataGenerator generator = new NumericDataGenerator("file.csv",5,0,100000);
        generator.start();
        generator = new NumericDataGenerator("file.csv", "output.csv", 5);
        generator.start();
    }
}
