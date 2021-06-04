package com.senla.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@MappedSuperclass
public abstract class AEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

}