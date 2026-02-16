package com.tss.temp.composit.test;


import com.tss.temp.composit.model.File;
import com.tss.temp.composit.model.Folder;

public class Main {
    public static void main(String[] args) {

        File file1 = new File("resume.pdf");
        File file2 = new File("photo.png");

        Folder documents = new Folder("Documents");
        Folder images = new Folder("Images");

        documents.add(file1);
        images.add(file2);

        Folder root = new Folder("Root");
        root.add(documents);
        root.add(images);

        root.showDetails();
    }
}
