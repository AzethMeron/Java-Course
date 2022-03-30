/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.google.gson.*;
import java.io.*;

import java.util.Arrays;
import java.security.SecureRandom;

import java.io.File;
import java.io.IOException;

public class Numbers {
    private double array[];
    final private static SecureRandom randomGenerator = new SecureRandom();
    private double sum;
    private int size;
    private int min_index;
    private int max_index;
    
    private static int GetRandomNum(int min, int max)
    {
        final int diff = Math.abs(max - min);
        final int rand_val = randomGenerator.nextInt(diff);
        return min + rand_val;
    }
    
    public Numbers(int n, int min, int max)
    {
        this.array = new double[n];
        this.sum = 0;
        this.size = n;
        this.min_index = 0;
        this.max_index = 0;
        for(int i = 0; i < n; ++i)
        {
            this.array[i] = this.GetRandomNum(min, max);
            this.sum = this.sum + this.array[i];
            if(this.array[i] > this.array[this.max_index]) this.max_index = i;
            if(this.array[i] < this.array[this.min_index]) this.min_index = i;
        }
    }
    
    public Numbers(String filename) throws Exception
    {
        this.Load(filename);
    }
    
    @Override public String toString()
    {
        String out = "[ ";
        for(int i = 0; i < this.size; ++i)
        {
            out = out + this.array[i] + ", ";
        }
        out = out + "]";
        return out;
    }
    
    public void Add(double num)
    {
        double new_array[] = new double[this.size+1];
        System.arraycopy(this.array, 0, new_array, 0, this.size);
        this.array = new_array;
        this.size = this.size + 1;
        if(num > this.Max()) this.max_index = this.size - 1; 
        if(num < this.Min()) this.min_index = this.size - 1; 
    }
    
    public void Sort()
    {
        Arrays.sort(this.array);
        this.min_index = 0;
        this.max_index = this.size - 1;
    }
    public double Average() { return this.sum / this.size; }
    public double Min() { return this.array[this.min_index]; }
    public double Max() { return this.array[this.max_index]; }
    public double Median()
    {
        double arr[] = new double[this.size];
        System.arraycopy(this.array, 0, arr, 0, this.size);
        Arrays.sort(arr);
        
        if((this.size % 2) == 1) return arr[this.size / 2];
        else {
            double l = arr[this.size / 2 - 1];
            double r = arr[this.size / 2];
            return (l+r)/2;
        }
    }
    
    public void Save(String filename) throws Exception
    {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(new File(filename))) {
            gson.toJson(this, writer);
            writer.flush();
        }
    }
    
    public void Load(String filename) throws Exception
    {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(new File(filename))) {
            Numbers loaded = gson.fromJson(reader, Numbers.class);
            this.array = loaded.array;
            this.size = loaded.size;
            this.sum = loaded.sum;
            this.min_index = loaded.min_index;
            this.max_index = loaded.max_index;
        }
        
    }
}
