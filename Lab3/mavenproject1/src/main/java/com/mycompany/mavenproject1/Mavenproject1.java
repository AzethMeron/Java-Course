/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject1;
/**
 *
 * @author meron
 */
public class Mavenproject1 {

    public static void main(String[] args) throws Exception {
        /*Numbers n = new Numbers(10, 1, 10);
        n.Load("temp.txt");
        System.out.println(n.Median());
        n.Sort();
        System.out.println(n);
        System.out.println(n.Average());
        System.out.println(n.Min());
        System.out.println(n.Max());*/
        
        MultiNumbers v = new MultiNumbers(0, 0);
        v.Load("araara.json");
        System.out.println(v);
        v.Save("araara.json");
    }
}
