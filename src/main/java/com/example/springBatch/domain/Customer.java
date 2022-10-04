package com.example.springBatch.domain;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer id;
    @Column(name = "name")
    String name;
}
