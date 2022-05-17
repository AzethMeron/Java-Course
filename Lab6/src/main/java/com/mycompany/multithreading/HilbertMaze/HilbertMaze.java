/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading.HilbertMaze;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;
import java.util.Comparator;

public class HilbertMaze {
    private ArrayList<ArrayList<Node>> maze = new ArrayList<>(); // maze[row][column]
    
    public int Size()
    {
        return this.maze.size();
    }
    
    static private int _SizeForN(int n)
    {
        return (int)Math.pow(2,(n+1)) + 1;
    }
    
    private void _Truncate(int n)
    {
        this.maze.clear();
        for(int r = 0; r < _SizeForN(n); ++r)
        {
            this.maze.add(new ArrayList<>());
            for(int c = 0; c < _SizeForN(n); ++c)
            {
                this.maze.get(r).add(new Node(true));
            }
        }
    }
    
    private void _Paste(int row_offset, int col_offset, HilbertMaze submaze)
    {
        for(int sub_row = 0; sub_row < submaze.Size(); ++sub_row)
        {
            for(int sub_col = 0; sub_col < submaze.Size(); ++sub_col)
            {
                int row = sub_row + row_offset;
                int col = sub_col + col_offset;
                Node obj = submaze.maze.get(sub_row).get(sub_col);
                this.maze.get(row).set(col, obj);
            }
        }
    }
    
    static private HilbertMaze _Initial() // działa
    {
        ArrayList<ArrayList<Node>> maze = new ArrayList<>();
        for(int r = 0; r < 5; ++r)
        {
            maze.add(new ArrayList<>());
            for(int c = 0; c < 5; ++c)
            {
                if(r>=1 && r <= 3 && c>=1 && c<=3)
                {
                    Node obj = (c == 2 && r != 3) ? new Node(true) : new Node(false);
                    maze.get(r).add(obj);
                }
                else
                {
                    maze.get(r).add(new Node(true));
                }
            }
        }
        HilbertMaze output = new HilbertMaze();
        output.maze = maze;
        return output;   
    }
    
    static public HilbertMaze Generate(int n) 
    {
        if(n == 1)
        {
            return _Initial();
        }
        
        HilbertMaze output = new HilbertMaze();
        output._Truncate(n);
        
        HilbertMaze topleft = new HilbertMaze(Generate(n-1));
        HilbertMaze topright = new HilbertMaze(topleft);
        HilbertMaze bottomleft = new HilbertMaze(topleft.Rotate(true));
        HilbertMaze bottomright = new HilbertMaze(topleft.Rotate(false));
        
        output._Paste(0, 0, bottomleft);
        output._Paste(0, _SizeForN(n)/2, bottomright);
        output._Paste(_SizeForN(n)/2, _SizeForN(n)/2, topright);
        output._Paste(_SizeForN(n)/2, 0, topleft);
        
        output.maze.get(_SizeForN(n)/2 + 1).set(_SizeForN(n)/2, new Node(false));
        output.maze.get(_SizeForN(n)/2).set(1, new Node(false));
        output.maze.get(_SizeForN(n)/2).set(_SizeForN(n) - 2, new Node(false));
        
        return output;
    }
    
    public HilbertMaze Rotate(boolean clockwise) // działa
    {
        ArrayList<ArrayList<Node>> output_maze = new ArrayList<>();
        for(int row = 0; row < this.maze.size(); ++row)
        {
            output_maze.add(new ArrayList<>());
            for(int column = 0; column < this.maze.get(row).size(); ++column)
            {
                Node obj = clockwise ? this.maze.get(column).get(row) : this.maze.get(this.maze.size() - 1 - column).get(row);
                output_maze.get(row).add(obj);
            }
        }
        HilbertMaze output = new HilbertMaze();
        output.maze = output_maze;
        return output;
    }
    
    private HilbertMaze() {} // hiding constructor
    
    @Override public String toString() // działa
    {
        String output = "";
        for(ArrayList<Node> row : this.maze)
        {
            for(Node n : row)
            {
                output = output + n;
            }
            output = output + "\n";
        }
        return output;
    }
    
    public void Mark(ArrayList<Point> path, char visual)
    {
        for(Point p : path)
        {
            int row = p.Row();
            int col = p.Column();
            this.maze.get(row).get(col).Mark(visual);
        }
    }
    
    public HilbertMaze(HilbertMaze tocopy)
    {
        for(int r = 0; r < tocopy.Size(); ++r)
        {
            this.maze.add(new ArrayList<>());
            for(int c = 0; c < tocopy.maze.get(r).size(); ++c)
            {
                Node obj = tocopy.maze.get(r).get(c);
                Node n = new Node(obj.Weight());
                this.maze.get(r).add(n);
            }
        }
    }
    
    public ArrayList<Point> Astar(int start_row, int start_col, int target_row, int target_col)
    {
        if(!this.maze.get(target_row).get(target_col).isPassable()) return null;
        ArrayList<Point> open_nodes = new ArrayList<>();
        open_nodes.add(new Point(start_row, 
                start_col, 
                this.maze.get(start_row).get(start_col),
                null,
                target_row,
                target_col
        ));
        ArrayList<Point> closed_nodes = new ArrayList<>();
        
        while(true)
        {
            if(open_nodes.isEmpty()) break;
            Collections.sort(open_nodes, new Comparator<Point>(){
                @Override public int compare(Point a, Point b){
                    return a.GetF() - b.GetF();
                }
           });
            
            ArrayList<Point> lowest_f = new ArrayList<>();
            for(Point p : open_nodes)
            {
                if(p.GetF() != open_nodes.get(0).GetF()) break;
                lowest_f.add(p);
            }
            Collections.sort(lowest_f, new Comparator<Point>(){
                @Override public int compare(Point a, Point b){
                    return a.GetH() - b.GetH();
                }
           });
            
            Point current_node = lowest_f.get(0);
            
            if((current_node.Row() == target_row) && (current_node.Column() == target_col))
                return current_node.GetPathTo();
            
            open_nodes.remove(current_node);
            closed_nodes.add(current_node);
            
            for(int offset_row = -1; offset_row <= 1; ++offset_row)
            {
                for(int offset_col = -1; offset_col <= 1; ++offset_col)
                {
                    if(Math.abs(offset_row) == Math.abs(offset_col)) continue;
                    int pos_row = current_node.Row() + offset_row;
                    int pos_col = current_node.Column() + offset_col;
                    if(pos_row < 0 || pos_row >= this.Size()) continue;
                    if(pos_col < 0 || pos_col >= this.Size()) continue;
                    Node n = this.maze.get(pos_row).get(pos_col);
                    Point neighbour = new Point(pos_row, pos_col, n, current_node, target_row, target_col);
                    if(closed_nodes.contains(neighbour) || !neighbour.Node().isPassable()) continue;
                    
                    if(open_nodes.contains(neighbour))
                    {
                        Point p = open_nodes.get(open_nodes.indexOf(neighbour));
                        p.Update(current_node, target_row, target_col);
                    }
                    else
                    {
                        open_nodes.add(neighbour);
                    }
                }
            }
        }
        return null;
    }
}
