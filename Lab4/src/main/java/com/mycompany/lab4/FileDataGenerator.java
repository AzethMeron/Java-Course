/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author meron
 */
public class FileDataGenerator {
    final private String path;
    final private ArrayList<String> names;
    final private ArrayList<String> surnames;
    
    public static ArrayList<String> Load(File file) throws Exception // Load file line by line, into array of strings
    {
        ArrayList<String> output = new ArrayList<>();
        try (Scanner myReader = new Scanner(file)) {
            while(myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                output.add(data);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return output;
    }
    
    private void ensureDir()
    {
        File directory = new File(this.path);
        if (!directory.exists()){
            directory.mkdir();
        }
    }
    
    public void generate(int fnum, int pnum) throws Exception
    {
        this.ensureDir();
        
        for(int i = 0; i < fnum; ++i)
        {
            String filepath = this.path + "/" + i + ".txt";
            File newfile = new File(filepath);
            newfile.createNewFile();
            
            String out = "";
            for(int j = 0; j < pnum; ++j)
            {
                Person p = new Person(names, surnames, 15, 42, 150, 200);
                out = out + p.ToString();
            }
            byte[] bytes = out.getBytes();
            Files.write(Paths.get(filepath), bytes);
        }
    }
    
    FileDataGenerator(String path) throws Exception
    {
        this.names = Load(new File("names.txt"));
        this.surnames = Load(new File("surnames.txt"));
        this.path = path;
    }
}
