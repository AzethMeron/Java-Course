/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class NumericDataParser implements Runnable
{
    private Thread t;
    final private FileOutputStream file;
    final private ArrayList<Long> numbers;
    
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
    
    public void run() 
    {
        ArrayList<Long> primes = new ArrayList<>();
        String data_to_save = new String();
        for(Long i : this.numbers)
        {
            boolean feedback = isPrime(i);
            if(feedback)
            {
                primes.add(i);
                data_to_save = data_to_save + String.format("%d\n", i);
            }
        }
        byte[] bytes = data_to_save.getBytes();
        synchronized(this.file)
        {
            try
            {
                System.out.println("Saving...");
                this.file.write(bytes);
            }
            catch (Exception e)
            {
                
            }
        }
    }
    
    NumericDataParser(FileOutputStream fileref, ArrayList<Long> numbers)
    {
        this.file = fileref;
        this.numbers = numbers;
        
    }
    
    public void start () {
      if (t == null) {
         t = new Thread (this);
         t.start ();
      }
   }
}

public class NumericDataGenerator {
    final private String path;
    final private FileOutputStream file;
    private ArrayList<NumericDataParser> threads;
    
    private ArrayList<Long> GenerateRange(long minval, long maxval)
    {
        ArrayList<Long> output = new ArrayList<>();
        for(long i = minval; i < maxval; ++i)
        {
            output.add(i);
        }
        return output;
    }
    
    private ArrayList<Long> LoadData(String path)
    {
        String content = readAllBytesJava7(path);
        String literals[]  = content.split("\n");
        ArrayList<Long> output = new ArrayList<>();
        for(String s : literals)
        {
            long r = Long.parseLong(s);
            output.add(r);
        }
        return output;
    }
    
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
    
    NumericDataGenerator(String path, int threadnum, long minval, long maxval) throws Exception
    {
        this.path = path;
        this.file = new FileOutputStream(path, true);
        this.threads = new ArrayList<>();
        long r = (maxval - minval) / threadnum;
        for(int i = 0; i < threadnum; ++i)
        {
            // min: r*i;
            // max: r*(i+1)
            ArrayList<Long> numbers = this.GenerateRange(r*i, r*(i+1));
            this.threads.add(new NumericDataParser(this.file, numbers));
        }
    }
    NumericDataGenerator(String input, String path, int threadnum) throws Exception
    {
        this.path = path;
        this.file = new FileOutputStream(path, true);
        this.threads = new ArrayList<>();
        ArrayList<Long> data = this.LoadData(input);
        int size_per_thread = data.size()/threadnum;
        
        for(int i = 0; i < threadnum; ++i)
        {
            ArrayList<Long> numbers = new ArrayList<>(data.subList(size_per_thread*i, size_per_thread*(i+1)));
            this.threads.add(new NumericDataParser(this.file, numbers));
        }
    }
    
    public void start()
    {
        for(NumericDataParser thread : this.threads)
        {
            thread.start();
        }
    }
}
