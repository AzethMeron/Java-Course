/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.multithreading;
import com.mycompany.multithreading.HilbertMaze.*;
import java.util.ArrayList;
import java.util.Collections;

public class Multithreading {

    public static int Accum(ArrayList<Point> path)
    {
        int output = 0;
        for(Point p : path)
        {
            output = output + p.Node().Weight();
        }
        return output;
    }
    
    public static void main(String[] args) throws Exception
    {
        HilbertMaze maze = HilbertMaze.Generate(3);
        ArrayList<Point> path = maze.Astar(6, 6, 13, 10);
        System.out.println(maze.Mark(13,10));
        System.out.println(Accum(path));
    }
}
