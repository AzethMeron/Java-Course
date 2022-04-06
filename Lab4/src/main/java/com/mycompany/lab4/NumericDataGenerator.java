/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

/**
 *
 * @author meron
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.security.SecureRandom;

public class NumericDataGenerator {
    final private String path;
    private ArrayList<Long> numbers = new ArrayList<>();
    private static SecureRandom randomGenerator = new SecureRandom();
    
    private static long GetRandomNum(long min, long max)
    {
        final long rand_val = randomGenerator.nextLong();
        return rand_val % (max - min + 1) + min;
    }
    
    public void generate(int num)
    {
        numbers.clear();
        
        for(int i = 0; i < num; ++i)
        {
            long r = GetRandomNum(1000000000L, 9999999999L);
            this.numbers.add(r);
        }
    }
    
    public void save() throws Exception
    {
        String out = "";
        for(Long n : this.numbers)
        {
            out = out + String.format("%d,", n);
        }
        byte[] bytes = out.getBytes();
        Files.write(Paths.get(this.path), bytes);
    }
    
    NumericDataGenerator(String path)
    {
        this.path = path;
    }
}
