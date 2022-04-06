/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author meron
 */
public class NumericDataParser {
    final private String path;
    private ArrayList<Long> numbers = new ArrayList<>();
    
    // https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/
    private static boolean isPrime(long n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
  
        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;
  
        for (long i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
  
        return true;
    }
    
    NumericDataParser(String path)
    {
        this.path = path;
    }
    
    // https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
    private static String readAllBytesJava7(String filePath) 
    {
        String content = "";
 
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return content;
    }
    
    public void load()
    {
        this.numbers.clear();
        String content = readAllBytesJava7(this.path);
        content = content.replace(",", " "); // https://careerkarma.com/blog/java-string-replace/
        String literals[]  = content.split(" ");
        for(String s : literals)
        {
            long r = Long.parseLong(s);
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
    
    public void selectPrimes()
    {
        ArrayList<Long> primes = new ArrayList<>();
        for(Long n : this.numbers)
        {
            if(isPrime(n))
                primes.add(n);
        }
        this.numbers = primes;
    }
    
    public int size() { return this.numbers.size(); }
    @Override public String toString()
    {
        String output = "";
        for(Long n : this.numbers)
        {
            output = output + String.format("%d\n", n);
        }
        return output;
    }
}
