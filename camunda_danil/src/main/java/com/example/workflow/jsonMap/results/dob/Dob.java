package com.example.workflow.jsonMap.results.dob;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dob {
    @JsonProperty
    private String date;

    @JsonProperty
    private int age;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dob{" +
                "date='" + date + '\'' +
                ", age=" + age +
                '}';
    }
}
