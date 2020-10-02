package com.company;

import java.io.*;

public class Main {

    public static ParkingLot parkingLot;

    public static void executeCommand(String line) throws Exception {
        String[] arrayOfStrings = line.split(" ");
        String command = arrayOfStrings[0];
        if (command.equals("Create_parking_lot")) {
            int noOfSlots = Integer.parseInt(arrayOfStrings[1]);
            parkingLot = new ParkingLot(noOfSlots);
            System.out.println("Created Parking of " + noOfSlots + " Slots");
        } else if (command.equals("Park")) {
            String regNo = arrayOfStrings[1];
            int age = Integer.parseInt(arrayOfStrings[3]);

            parkingLot.parkVehicle(regNo, age);
        } else if (command.equals("Slot_number_for_car_with_number")) {
            String regNo = arrayOfStrings[1];
            System.out.println(parkingLot.getSlotNumberFromVehicle(regNo));
        } else if (command.equals("Slot_numbers_for_driver_of_age")) {

            int age = Integer.parseInt(arrayOfStrings[1]);
            parkingLot.getParkingSlotsFromAge(age);
        } else if (command.equals("Vehicle_registration_number_for_driver_of_age")) {
            int age = Integer.parseInt(arrayOfStrings[1]);
            parkingLot.getVehiclesFromAge(age);
        } else if (command.equals("Leave")) {
            int slotNumber = Integer.parseInt(arrayOfStrings[1]);
            parkingLot.vacateSlot(slotNumber);
        } else{
            System.out.println("Wrong Command");
        }
    }

    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader(".\\testout.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            executeCommand(line);
        }
        fr.close();
    }
}
