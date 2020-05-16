package com.apartment.management.model;

import lombok.Data;

@Data
public class BookRoom {
    private int id;
    private String user_name;
    private String id_card;
    private int room_nummber;
    private String in_time;
    private String out_time;
    private int deposit;
}
