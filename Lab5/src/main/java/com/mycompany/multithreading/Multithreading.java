/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.multithreading;
import java.util.ArrayList; 

// Src:
// https://www.tutorialspoint.com/java/java_multithreading.htm
// https://www.baeldung.com/java-generating-random-numbers-in-range#intstreamiterate-1
// https://www.w3schools.com/java/java_arraylist.asp
// https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/
// https://howtodoinjava.com/java/io/java-read-file-to-string-examples/


public class Multithreading {

    public static void main(String[] args) throws Exception
    {
        // Task 1
        /*ArrayList<MyThread> threads = new ArrayList<MyThread>();
        for(int i = 0; i < 5; ++i)
        {
            MyThread e = new MyThread(i,"Thread"+i);
            threads.add(e);
            e.start();
        }*/
        
        // Task 2
        //NumericDataGenerator generator = new NumericDataGenerator("file.csv",5,0,10000000);
        NumericDataGenerator generator = new NumericDataGenerator("file.csv", "output.csv", 5);
        generator.start();
    }
}
