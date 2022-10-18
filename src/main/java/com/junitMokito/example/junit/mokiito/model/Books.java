package com.junitMokito.example.junit.mokiito.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Books
{
    @Id
    private Integer id;
    private String name;
    private Integer price;
}

