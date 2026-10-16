package com.example.seminarapp_70151016;

public class Registration {
    private String name;
    private String email;

    public Registration(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isValid() {
        return !name.isEmpty() && email.contains("@");
    }
}
