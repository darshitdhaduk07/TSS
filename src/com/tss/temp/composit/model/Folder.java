package com.tss.temp.composit.model;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem {
    private String name;
    private List<FileSystem> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystem component) {
        components.add(component);
    }

    public void remove(FileSystem component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);

        for (FileSystem component : components) {
            component.showDetails();
        }
    }
}
