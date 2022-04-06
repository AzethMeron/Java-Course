/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author meron
 */
public class FileDataParser {
    private People people = new People();
    // https://stackoverflow.com/questions/3626752/key-existence-check-in-hashmap
    // https://stackoverflow.com/questions/13543457/how-do-you-create-a-dictionary-in-java
    private Map<String, People> people_sub = new HashMap<>();
    private Set<String> list_of_files;
    
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
    
    // https://www.baeldung.com/java-list-directory-files
    public Set<String> ListFilesInDirectory(String dir) throws Exception {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                        .toString());
                }
            }
        }
        return fileList;
    }
    
    public int size() { return this.people.size(); }
    
    public String oldest() {
        String output = "";
        for(String filename : this.list_of_files)
        {
            People local_ppl = this.people_sub.get(filename);
            local_ppl.sortByAge();
            local_ppl.reverse();
            Person oldest = local_ppl.getPersonList().get(0);
            output = output + String.format("Oldest in %s: %s %s %d\n", filename, oldest.getName(), oldest.getSurname(), oldest.getAge());
        }
        this.people.sortByAge();
        this.people.reverse();
        Person oldest = this.people.getPersonList().get(0);
        output = output + String.format("Oldest in entire set: %s %s %d", oldest.getName(), oldest.getSurname(), oldest.getAge());
        return output;
    }
    
    public void oldestCSV(String csv_filename) throws Exception
    {
        String output = "";
        for(String filename : this.list_of_files)
        {
            People local_ppl = this.people_sub.get(filename);
            local_ppl.sortByAge();
            local_ppl.reverse();
            Person oldest = local_ppl.getPersonList().get(0);
            output = output + String.format("%s,%s,%s,%d\n", filename, oldest.getName(), oldest.getSurname(), oldest.getAge());
        }
        this.people.sortByAge();
        this.people.reverse();
        Person oldest = this.people.getPersonList().get(0);
        output = output + String.format("total, %s, %s, %d\n", oldest.getName(), oldest.getSurname(), oldest.getAge());
        byte[] bytes = output.getBytes();
        Files.write(Paths.get(csv_filename), bytes);
    }
    
    public String averageSalary() {
        String output = "";
        for(String filename : this.list_of_files)
        {
            People local_ppl = this.people_sub.get(filename);
            double average = local_ppl.averageSalary();
            output = output + String.format("Average salary in %s: %f\n", filename, average);
        }
        double average = this.people.averageSalary();
        output = output + String.format("Average salary in total: %f\n", average);
        return output;
    }
    
    public void averageSalaryCSV(String csv_filename) throws Exception
    {
        String output = "";
        for(String filename : this.list_of_files)
        {
            People local_ppl = this.people_sub.get(filename);
            double average = local_ppl.averageSalary();
            output = output + String.format("%s,%f\n", filename, average);
        }
        double average = this.people.averageSalary();
        output = output + String.format("total, %f", average);
        byte[] bytes = output.getBytes();
        Files.write(Paths.get(csv_filename), bytes);
    }
    
    FileDataParser(String path) throws Exception
    {
        this.list_of_files = ListFilesInDirectory(path);
        for(String filename : this.list_of_files)
        {
            ArrayList<String> lines = Load(new File(path + "/" + filename));
            for(String line : lines)
            {
                Person p = Person.FromString(line);
                this.people.addPerson(p);
                if(this.people_sub.get(filename) == null) { this.people_sub.put(filename, new People()); }
                this.people_sub.get(filename).addPerson(p);
            }
        }
    }
}
