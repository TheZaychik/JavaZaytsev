package com.example.controlworkrestapi.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cities")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}
