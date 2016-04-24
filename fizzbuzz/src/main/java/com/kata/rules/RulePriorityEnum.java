package com.kata.rules;

public enum RulePriorityEnum {

    HIGH(1),
    LOW(2);

    private int value;

    RulePriorityEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
