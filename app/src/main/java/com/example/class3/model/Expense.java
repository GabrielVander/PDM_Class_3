package com.example.class3.model;

public class Expense {
    private String description;
    private Double value;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expense {" +
                "description ='" + description + '\'' +
                ", value = " + value +
                '}';
    }
}
