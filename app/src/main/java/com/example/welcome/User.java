package com.example.welcome;

public class User {
    public User(String name, String poss) {
        this.name=name;
        this.pass=poss;
    }
    public User()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    String name,pass;
}
