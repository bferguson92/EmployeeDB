package com.example.employeedb.model;

public class Employee {
    private String name;
    private String tech;
    private String position;

    public Employee() {
    }

    public Employee(String name, String tech, String position) {
        this.name = name;
        this.tech = tech;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
