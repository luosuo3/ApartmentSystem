package com.apartment.management.model;

import java.io.Serializable;
import lombok.Data;

/**
 * message
 * @author 
 */
@Data
public class Message implements Serializable {
    private Integer id;

    private String userName;

    private Integer userType;

    private String title;

    private String description;

    private static final long serialVersionUID = 1L;
}