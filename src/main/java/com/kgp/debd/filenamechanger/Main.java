/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kgp.debd.filenamechanger;

import java.io.File;

/**
 *
 * @author Debasish
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("========== File Name Changer ==========");

        // check argumants
        if (args.length < 2) {
            System.out.println("Please provide full path to a directory and type");
            System.out.println("USAGE: java -jar FileNameChanger <path> <odd/even>");
            System.exit(1);
        }

        // get type and files
        String type = args[1];
        File rootDir = new File(args[0]);

        System.out.println("Root Path : "+rootDir.getAbsolutePath());
        
        // check if provided path is directory or not
        if (!rootDir.isDirectory()) {
            System.out.println(args[0] + " is not a directory");
            System.exit(2);
        }

        File[] files = rootDir.listFiles();
        int count = type.equalsIgnoreCase("odd") ? 1 : 2;
        for (File f : files) {
            if (!f.isDirectory()) {              
                boolean success = f.renameTo(new File(f.getParent()+ File.separator + count + " " + f.getName()));
                if (success) {
                    System.out.println("Renamed: " + f.getName());
                    count += 2;
                }
            }
        }

    }

}
