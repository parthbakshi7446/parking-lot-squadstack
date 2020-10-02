package com.company;

import com.company.AgeGroup;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private int noOfSlots;
    public AgeGroup[] ageGroupArray;
    HashMap<String, Vehicle> vehicleHashMap;
    public ParkingSlot[] slots;

    /**
     * Creates a parking lot with given number of slots.
     */
    ParkingLot(int slotsCount) {
        noOfSlots = slotsCount;
        vehicleHashMap = new HashMap<>();
        ageGroupArray = new AgeGroup[100];
        slots = new ParkingSlot[slotsCount + 1];
    }

    public void parkVehicle(String regNo, int age) throws Exception {
        if (ageGroupArray[age] == null) {
            ageGroupArray[age] = new AgeGroup(age);
        }
        Vehicle vehicle = new Vehicle(regNo);
        parkVehicleInternal(vehicle, ageGroupArray[age]);
    }

    /**
     * Parks the given vehicle with given driver age.
     */
    public void parkVehicleInternal(Vehicle vehicle, AgeGroup ageGroup) throws Exception {
        int availableSlot = getFirstAvailableSlot();
        slots[availableSlot] = new ParkingSlot(vehicle, ageGroup, availableSlot);
        vehicle.slot = slots[availableSlot];
        vehicleHashMap.putIfAbsent(vehicle.registrationNumber, vehicle);
        ageGroup.addVehicle(vehicle);
        System.out.println("Car with vehicle registration number “" + vehicle.registrationNumber + "” has been parked at slot number " + availableSlot);
    }

    /**
     * Empties the given slot and mark it as available.
     */
    public void vacateSlot(int slotNumber) throws Exception {
        if (slots[slotNumber] == null) {
            throw new Exception("Slot Already Vacant");
        }
        Vehicle currentVehicle = slots[slotNumber].vehicle;
        int age = slots[slotNumber].ageGroup.age;
        slots[slotNumber].ageGroup.deleteVehicle(currentVehicle);
        vehicleHashMap.remove(currentVehicle.registrationNumber);
        slots[slotNumber] = null;
        System.out.println("Slot number " + slotNumber + " vacated, the car with vehicle registration number “ " + currentVehicle.registrationNumber + " ” left the space, the driver of the car was of age " + age + "\n");
    }

    /**
     * using MEX
     */
    public int getFirstAvailableSlot() throws Exception {
        for (int i = 1; i <= noOfSlots; i++) {
            if (slots[i] == null) {
                return i;
            }
        }
        throw new Exception("NoSlotFound");
    }

    /**
     * print all the vehicles parked by people of given age
     */
    public ArrayList<String> getVehiclesFromAge(int age) throws Exception {
        ArrayList<String> result = new ArrayList<>();
        if (ageGroupArray[age] == null) {
            return result;
        }
        for (Vehicle vehicle : ageGroupArray[age].vehicles) {
            result.add(vehicle.registrationNumber);
        }
        for (String i : result)
            System.out.print(i + ",");
        System.out.println();
        return result;

    }

    /**
     * Returns the slot number of a vehicle where it is parked , provide registration numer of vehicle
     */
    public int getSlotNumberFromVehicle(String regNo) throws Exception {
        return vehicleHashMap.get(regNo).slot.id;
    }

    /**
     * prints parking slots for the given age of people parked their cars into those slots
     */
    public ArrayList<Integer> getParkingSlotsFromAge(int age) throws Exception {
        ArrayList<Integer> result = new ArrayList<>();
        if (ageGroupArray[age] == null) {
            return result;
        }
        for (Vehicle vehicle : ageGroupArray[age].vehicles) {
            result.add(vehicle.slot.id);
        }
        for (Integer i : result)
            System.out.print(i + ",");
        System.out.println();
        return result;
    }
}
