package com.junitMokito.example.junit.mokiito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class BookDto {
    private Integer id;
    private String name;
    private Integer price;
}
