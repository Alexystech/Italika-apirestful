package com.itsx.slasher.italikaapirest.service;

import com.itsx.slasher.italikaapirest.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    boolean createVehicle(Vehicle vehicle);
    boolean removeVehicleByPlaque(String plaque);
    boolean updateVehicle(Vehicle vehicle);
    Vehicle getVehicleByPlaque(String plaque);
    List<Vehicle> getAllVehicles();
}
