/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab4;

/**
 *
 * @author meron
 */
public class Lab4 {
    
    public static void main(String[] args) throws Exception {
        FileDataGenerator gen = new FileDataGenerator("ara");
        gen.generate(100, 20);
        FileDataParser p = new FileDataParser("ara");
        //System.out.println(p.averageSalary());
        //System.out.println(p.oldest());
        p.oldestCSV("o.csv");
       
        /*NumericDataGenerator gen = new NumericDataGenerator("numbers.csv");
        gen.generate(10000);
        gen.save();
       
        NumericDataParser p = new NumericDataParser("numbers.csv");
        p.load();
        p.selectPrimes();
        p.save();
        System.out.println(p);*/
    }
}
