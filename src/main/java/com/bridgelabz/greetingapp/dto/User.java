package com.bridgelabz.greetingapp.dto;

import lombok.Data;

@Data
public class User {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
