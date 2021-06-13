package com.flock.test.flocktest.models;

public enum Role {
    ADMIN("ADMIN"),
    PROD("PROD"),
    CLIENT("CLIENT");

    private final String value;

    Role(String value) { this.value = value; }

    public String getValue() { return this.value; }
}
