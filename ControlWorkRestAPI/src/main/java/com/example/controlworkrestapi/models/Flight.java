package com.example.controlworkrestapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "flights")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    private String aviaName;

    private Date datetime;

    private Integer duration;
}
