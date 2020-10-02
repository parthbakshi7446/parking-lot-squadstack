package com.company;

import com.company.ParkingSlot;

public class Vehicle {
    public String registrationNumber;
    public ParkingSlot slot;

    Vehicle(String regNo) {
        this.registrationNumber = regNo;
    }
}
