package com.junitMokito.example.junit.mokiito.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Books books = (Books) o;
        return id != null && Objects.equals(id, books.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

