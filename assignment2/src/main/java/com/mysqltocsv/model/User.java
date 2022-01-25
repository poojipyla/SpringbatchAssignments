package com.mysqltocsv.model;

public class User {
    private String gender;
    private String race;
    private String parental_level_of_education;
    private String test_preparation_course;
    private Integer math_score;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getParental_level_of_education() {
		return parental_level_of_education;
	}
	public void setParental_level_of_education(String parental_level_of_education) {
		this.parental_level_of_education = parental_level_of_education;
	}
	public String getTest_preparation_course() {
		return test_preparation_course;
	}
	public void setTest_preparation_course(String test_preparation_course) {
		this.test_preparation_course = test_preparation_course;
	}
	public Integer getMath_score() {
		return math_score;
	}
	public void setMath_score(Integer math_score) {
		this.math_score = math_score;
	}
    
    

}