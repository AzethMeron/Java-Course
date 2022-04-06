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
        p.averageSalaryCSV("s.csv");
       
        NumericDataGenerator gen1 = new NumericDataGenerator("numbers.csv");
        gen1.generate(10000);
        gen1.save();
       
        NumericDataParser p1 = new NumericDataParser("numbers.csv");
        p1.load();
        p1.selectPrimes();
        p1.save();
        System.out.println(p1);
    }
}
