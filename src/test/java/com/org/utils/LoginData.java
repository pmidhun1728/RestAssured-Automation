package com.org.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginData {
    private String email;
    private String password;
}
