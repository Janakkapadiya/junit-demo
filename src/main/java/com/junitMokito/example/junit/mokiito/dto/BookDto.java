package com.junitMokito.example.junit.mokiito.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class BookDto {
    private Integer id;
    private String name;
    private Integer price;
}
