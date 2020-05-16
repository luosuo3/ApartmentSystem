package com.apartment.management.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String user_name;
    private String password;
    private int type;
}
