package com.tss.temp.proxy.test;

import com.tss.temp.proxy.model.Image;
import com.tss.temp.proxy.model.ProxyImage;

public class Main {
    public static void main(String[] args) {

        Image image = new ProxyImage("photo.jpg");

        image.display(); // loads + displays
        image.display(); // only displays
    }
}
