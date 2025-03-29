package com.org.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class PostManData {
    private  String title;
    private String author;
    private int published;
}
