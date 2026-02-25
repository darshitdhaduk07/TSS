package com.tss.filehandling.movieapp.module;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMain {
    public static void printfile(File f)
    {
        File[] files = f.listFiles();

        for(File file : files)
        {
            if(f.isDirectory())
                printfile(file);
            else
                System.out.println(f.getName());
        }

    }
    public static void main(String[] args) {


           File file = new File("C:\\Users\\Darshit.Dhaduk\\Desktop\\example\\hello.txt");

           if(!file.exists())
           {
               System.out.println("path not exist");
               return;
           }

           if(file.isDirectory())
           {
               File[] files = file.listFiles();

               for(File f : files)
               {
                   if(f.isDirectory())
                       printfile(f);
                   else
                        System.out.println(f.getName());
               }
           }
           else if(file.isFile()) {
               System.out.println("File Content");
               try (Scanner sc = new Scanner(file)) {
                   while (sc.hasNextLine()) {
                       System.out.println(sc.nextLine());
                   }
               } catch (FileNotFoundException e) {
                   System.out.println(e);
               }
           }


    }
}
