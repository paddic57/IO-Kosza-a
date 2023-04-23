package com.example.punkty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NewStudent {
    @JsonProperty("name")
    final String name;
    @JsonProperty("number")
    final String number;
    @JsonProperty("groupp")
    final String groupp;

    @JsonCreator
    public NewStudent(String name, String number, String groupp) {
        this.name = name;
        this.number = number;
        this.groupp = groupp;
    }
}
