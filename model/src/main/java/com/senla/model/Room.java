package com.senla.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.*;

@Data
@Entity
@Log4j
@Table(name = "rooms")
public class Room extends AEntity {

    private static final long serialVersionUID = -4228828661543183387L;
    @Column(name = "number")
    private Integer number;
    @Column(name = "price")
    private Integer price;
    @Column(name = "capacity")
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('EMPTY', 'SERVICED')")
    private RoomStatus status;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('STANDARD', 'JUNIOR_SUITE', 'LUX', 'PRESIDENT_LUX')")
    private RoomStars stars;
    private boolean isEmpty;

    public Room(){

    }

    public Room(Integer number, Integer price, Integer capacity, RoomStatus status, RoomStars stars) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.status = status;
        this.stars = stars;
    }


    @Override
    public String toString() {
        return "Room : " +
                "Id " + getId() +
                " number " + number +
                " Price " + price +
                " Capacity " + capacity +
                " Status " + status +
                " Stars " + stars;

    }

}

