package com.company;

import com.company.AgeGroup;

public class ParkingSlot {
    public int id;
    public AgeGroup ageGroup;

    public Vehicle vehicle;

    ParkingSlot(Vehicle vehicle, AgeGroup ageGroup, int id) {
        this.id = id;
        this.ageGroup = ageGroup;
        this.vehicle = vehicle;
    }

}
