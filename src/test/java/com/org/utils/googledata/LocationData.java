package com.org.utils.googledata;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LocationData {

    private Location location;
    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List<String> types;
    private String website;
    private String language;
}
