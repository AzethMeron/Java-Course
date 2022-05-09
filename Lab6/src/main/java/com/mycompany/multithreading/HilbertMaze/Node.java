/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreading.HilbertMaze;

/**
 *
 * @author meron
 */
public class Node {
    private int weight = 0;
    
    public boolean isPassable()
    {
        return this.weight != Integer.MAX_VALUE;
    }
    
    public int Weight()
    {
        return this.weight;
    }
    
    public Node(boolean passable)
    {
        this.weight = passable ? 1 : Integer.MAX_VALUE;
    }
    
    public Node(int weight)
    {
        this.weight = weight;
    }
}
