package br.edu.fa7.demoapp;

/**
 * Created by posgrad on 19/08/2015.
 */
public class Person {

    private String name;
    private String email;
    private int image;

    public Person(String name, String email, int image) {
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getImage() {
        return image;
    }
}
