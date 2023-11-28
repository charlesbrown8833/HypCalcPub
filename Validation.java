/*
Charles Brown
CITC-1311-C01
Chapter 12
Sept. 16, 2023
*/
package com.murach.hypotenusecalculator;

public class Validation {

    private final String lineEnd;

    public Validation() {
        this.lineEnd = "\n";
    }

    public Validation(String lineEnd) {
        this.lineEnd = lineEnd;
    }

    public String isPresent(String value, String name) {
        String msg = "";
        if (value.isEmpty()) {
            msg = name + " is required." + lineEnd;
        }
        return msg;
    }

    public String isDouble(String value, String name) {
        String msg = "";
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            msg = name + " must be a valid number." + lineEnd;
        }
        return msg;
    }

    public String isInteger(String value, String name) {
        String msg = "";
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            msg = name + " must be an integer." + lineEnd;
        }
        return msg;
    }
}
