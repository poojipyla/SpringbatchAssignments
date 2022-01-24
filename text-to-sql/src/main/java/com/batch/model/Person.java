package com.batch.model;

import lombok.Getter;
import lombok.Setter;

public class Person {
    private @Getter @Setter int id;
    private @Getter @Setter String name;

    @Override
    public String toString() {

        return "Person [id=" + id + ", name=" + name + "]";
    }



}