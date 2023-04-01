package com.example.controlworkrestapi.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "routes")
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "city_from")
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name = "city_to")
    private City cityTo;

}
