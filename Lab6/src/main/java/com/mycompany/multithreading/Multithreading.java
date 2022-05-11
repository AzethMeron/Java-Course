/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.multithreading;
import com.mycompany.multithreading.HilbertMaze.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Multithreading {

    // calculate weight (length) of path in Hilbert Maze
    public static int Accum(ArrayList<Point> path)
    {
        int output = 0;
        for(Point p : path)
        {
            output = output + p.Node().Weight();
        }
        return output;
    }
    
    public static void HilbertMazeExample()
    {
        HilbertMaze maze = HilbertMaze.Generate(3);
        ArrayList<Point> path = maze.Astar(6, 6, 13, 10);
        maze.Mark(path, ',');
        System.out.println(maze);
        System.out.println(Accum(path));
    }
    
    public static void main(String[] args) throws Exception
    {
        HilbertMazeExample();
        ArrayList<Integer> p = new ArrayList<>();
        p.add(2);
        p.add(-5);
        p.add(1);
        Collections.sort(p, new Comparator<Integer>(){
                @Override public int compare(Integer a, Integer b){
                    return a - b;
                }
           });
        System.out.println(p);
    }
}
