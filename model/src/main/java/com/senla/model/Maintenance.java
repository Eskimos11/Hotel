package com.senla.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j
@Entity
@Table(name = "maintenance")
public class Maintenance extends AEntity {

    private static final long serialVersionUID = -995649778035522944L;
    @Column(name = "name")
    private String name;
    @Column(name= "price")
    private Integer price;

    @Override
    public String toString() {
        return "Maintenance " +
                "Id " + getId() +
                " name " + name +
                " price " + price + "$";
    }

}



