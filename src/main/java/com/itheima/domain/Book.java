package com.itheima.domain;
//lombok

import lombok.Data;
import lombok.Getter;

@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
