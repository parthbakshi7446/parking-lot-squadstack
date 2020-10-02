package com.company;

import com.company.ParkingSlot;

/**
 * stores info about the vehicle entering intoo parking lot
 */
public class Vehicle {
    public String registrationNumber;
    public ParkingSlot slot;

    Vehicle(String regNo) {
        this.registrationNumber = regNo;
    }
}
