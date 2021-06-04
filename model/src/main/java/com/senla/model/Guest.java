package com.senla.model;




import lombok.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guests")
public class Guest extends AEntity {

    private static final long serialVersionUID = 2739957653192703724L;
    @Column(name = "lastname")
    private String lastname;

    @Override
    public String toString() {
        return "Guest " +
                "Id " + getId() +
                " lastName " + lastname;
    }

}










