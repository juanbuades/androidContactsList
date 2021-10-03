package com.example.myapplication;

import java.io.Serializable;

public class Enemy implements Serializable {
    String name;
    Integer age;
    String description;

    public Enemy (String name, Integer age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public Enemy(){
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
