package com.batch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private @Getter @Setter int id;
    private @Getter @Setter String name;

    @Override
    public String toString() {

        return "Person [id=" + id + ", name=" + name + "]";
    }

}