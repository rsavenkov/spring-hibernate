package ru.easyum.spring.lifecycle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

public class LifecycleBean {

    private String secret;

    public void init() {
        System.out.print("Start generating secret... ");
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        secret = new String(array, Charset.forName("UTF-8"));
        System.out.println("done.");
    }

    public String showMeSecret() {
        return secret;
    }

    public void destroy() throws IOException {
        System.out.print("Write secret data to file... ");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("secret.txt"))) {
            writer.write(secret);
        }
        System.out.println("done.");
    }
}
