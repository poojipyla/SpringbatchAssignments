package com.xmltodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="user")

@NoArgsConstructor
@AllArgsConstructor
public class User {
    private @Getter @Setter int userId;
    private @Getter @Setter String first_Name;
    private @Getter@Setter String last_Name;
    private @Getter @Setter String email;
    private @Getter @Setter int age;


}
