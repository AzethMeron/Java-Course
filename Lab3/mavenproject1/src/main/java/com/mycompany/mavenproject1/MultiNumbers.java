/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 *
 * @author meron
 */
public class MultiNumbers {
    ArrayList<Numbers> numbers;
    
    public MultiNumbers(int s, int n)
    {
        numbers = new ArrayList<Numbers>();
        for(int i = 0; i < s; ++i)
        {
            numbers.add(new Numbers(n, 0, 10));
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
            MultiNumbers loaded = gson.fromJson(reader, MultiNumbers.class);
            this.numbers = loaded.numbers;
        }
    }
    
    @Override public String toString()
    {
        String out = "";
        for(int i = 0; i < this.numbers.size(); ++i)
        {
            out = out + this.numbers.get(i) + "\n";
        }
        return out;
    }
}
