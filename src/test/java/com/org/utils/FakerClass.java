package com.org.utils;

import com.github.javafaker.Faker;

public class FakerClass {

    private static final Faker faker = new Faker();

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getName() {
        return faker.name().firstName();
    }

    public static int getId() {
        return faker.hashCode();
    }

    public static String getPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }
}
