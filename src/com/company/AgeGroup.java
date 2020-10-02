package com.company;

import java.util.ArrayList;

/**
 *
 */
public class AgeGroup {
    public int age;
    public ArrayList<Vehicle> vehicles;

    AgeGroup(int age) {
        this.age = age;
        vehicles = new ArrayList<>();
    }

    public void deleteVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
