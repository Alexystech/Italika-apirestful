package com.itsx.slasher.italikaapirest.service.impl;

import com.itsx.slasher.italikaapirest.entity.Vehicle;
import com.itsx.slasher.italikaapirest.repository.VehicleRepository;
import com.itsx.slasher.italikaapirest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public boolean createVehicle(Vehicle vehicle) {
        if ( vehicle != null ) {
            vehicleRepository.save(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVehicleByPlaque(String plaque) {
        if ( !plaque.trim().equals("") || plaque != null ) {
            vehicleRepository.deleteById(plaque);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        if ( vehicle != null ) {
            vehicleRepository.save(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public Vehicle getVehicleByPlaque(String plaque) {
        return vehicleRepository.findById(plaque).get();
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = (List<Vehicle>) vehicleRepository.findAll();
        return vehicles;
    }
}
