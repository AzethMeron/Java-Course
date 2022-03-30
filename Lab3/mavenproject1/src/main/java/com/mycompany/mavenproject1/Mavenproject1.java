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
        
        Numbers z = new Numbers(10, 1, 10);
        z.Save("temp.json");
        
        Numbers n = new Numbers("temp.json");
        System.out.println(n);
        
        MultiNumbers v = new MultiNumbers("araara.json");
        System.out.println(v);
        v.Save("araara.json");
    }
}
