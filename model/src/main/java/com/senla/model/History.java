package com.senla.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j
@Entity
@Table(name = "history")
public class History extends AEntity {

    private static final long serialVersionUID = -2049215894052172046L;
    @OneToOne
    @JoinColumn(name = "rooms_id")
    private Room room;
    @OneToOne
    @JoinColumn(name = "guests_id")
    private Guest guest;
    @Column(name = "checkInDate")
    private LocalDate checkInDate;
    @Column(name = "checkOutDate")
    private LocalDate checkOutDate;
    @ManyToMany
    @JoinColumn(name = "maintenance_id")
    private List<Maintenance> maintenances;
    private boolean guestCheckIn;

    @Override
    public String toString() {
        return "History " + "Id " + getId() +
                ": -> " + getRoom() +
                ", guest=" + getGuest() +
                ", checkInDate=" + getCheckInDate() +
                ", checkOutDate=" + getCheckOutDate() +
                ", MaintenanceService=" + getMaintenances() +
                "  GuestCheckIn " + isGuestCheckIn()
                ;
    }

}
