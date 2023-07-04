package com.example.ejada.models;

import lombok.Data;

@Data
public class Statistics {
    private int func1Count;
    private int func2Count;
    private int func3Count;
    private int numberOfIssues;

    public Statistics() {
        this.func1Count = 0;
        this.func2Count = 0;
        this.func3Count = 0;
        this.numberOfIssues = 0;
    }
}
