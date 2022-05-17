/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading.HilbertMaze;
import java.lang.Math;
import java.util.ArrayList;
import java.util.*;

public class Point {
    final private int row;
    final private int column;
    final private Node node;
    
    private int g = 0;
    private int h = 0;
    private int f = 0;
    private Point previous = null;
    
    public static int ManhattanDistance(Point pos, int target_row, int target_col)
    {
        return Math.abs(pos.Row() - target_row) + Math.abs(pos.Column() - target_col);
    }
    
    public Point(int r, int c, Node n, Point prev, int target_row, int target_col)
    {
        this.row = r;
        this.column = c;
        this.node = n;
        this.previous = prev;
        
        this.g = prev != null ? prev.g + prev.node.Weight() : 0;
        this.h = ManhattanDistance(this, target_row, target_col);
        this.f = this.g + this.h;
    }
    
    public int Row() { return this.row; }
    public int Column() { return this.column; }
    public Node Node() { return this.node; }
    
    public void Mark(char visual)
    {
        this.node.Mark(visual);
    }
    
    public void Update(Point prev, int target_row, int target_col)
    {
        if(this.previous.g > prev.g)
        {
            this.previous = prev;
            this.g = prev.g + this.node.Weight();
            this.h = ManhattanDistance(this, target_row, target_col);
            this.f = this.g + this.h;
        }
    }
    
    public ArrayList<Point> GetPathTo()
    {
        ArrayList<Point> output = new ArrayList<>();
        for(Point iter = this; iter != null; iter = iter.previous)
        {
            output.add(iter);
        }
        Collections.reverse(output);
        return output;
    }
    
    public int GetF() { return this.f; }
    public int GetH() { return this.h; }
    
    @Override public boolean equals(Object v) {
        if(v instanceof Point)
        {
            Point ptr = (Point) v;
            if(this.row == ptr.row && this.column == ptr.column) return true;
        }
        return false;
    }
    
    @Override public String toString()
    {
        return String.format("(%d,%d)", this.row, this.column);
    }
}
