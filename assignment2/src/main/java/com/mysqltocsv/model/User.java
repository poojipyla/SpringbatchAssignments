package com.mysqltocsv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class User {
    private @Getter @Setter String gender;
    private @Getter @Setter String race;
    private @Getter @Setter String parental_level_of_education;
    private @Getter @Setter String test_preparation_course;
    private @Getter @Setter Integer math_score;

}