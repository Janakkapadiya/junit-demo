package com.junitMokito.example.junit.mokiito.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Books {
    @Id
    private int id;
    private String name;
}

