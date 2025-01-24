package com.food.ordering.system.messaging;

import lombok.Getter;

@Getter
public enum DebeziumOp {

    CREATE("c"), UPDATE("u"), DELETE("d");

    private final String value;
    DebeziumOp(String val) {
        this.value = val;
    }
}
