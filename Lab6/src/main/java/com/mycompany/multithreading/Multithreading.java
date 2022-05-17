/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.multithreading;
import com.mycompany.multithreading.HilbertMaze.*;
import java.util.ArrayList;
import com.mycompany.multithreading.customerclerks.*;
import java.util.concurrent.TimeUnit;

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
    
    public static void CustomersClerksExample()throws Exception
    {
        final int clerk_num = 3;
        Queue queue = new Queue(10);
        ArrayList<MyThread> threads = new ArrayList<>();
        threads.add(new MyThread(new CustomerGenerator(queue)));
        for(int i = 0; i < clerk_num; ++i) { threads.add(new MyThread(new Clerk(queue))); }
        while(true)
        {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(queue);
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        //HilbertMazeExample();
        CustomersClerksExample();
    }
}
