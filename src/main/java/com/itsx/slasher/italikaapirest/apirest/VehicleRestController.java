package com.itsx.slasher.italikaapirest.apirest;

import com.itsx.slasher.italikaapirest.entity.Vehicle;
import com.itsx.slasher.italikaapirest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleRestController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleRestController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /**
     * create a vehicle
     * @param vehicle
     * @return
     */
    @PostMapping("/create/vehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {

        if ( vehicle == null ) {
            throw new RuntimeException("vehicle is null");
        }

        vehicleService.createVehicle(vehicle);

        return ResponseEntity.ok(vehicle);
    }

    /**
     * remove a vehicle by plaque
     * @param plaque
     * @return
     */
    @DeleteMapping("/delete/vehicle/{plaque}")
    public ResponseEntity<Boolean> deleteVehicleByFolio(@PathVariable String plaque) {

        Vehicle vehicle = vehicleService.getVehicleByPlaque(plaque);

        if ( vehicle == null ) {
            throw new RuntimeException("vehicle don't exist - " + plaque);
        }

        vehicleService.removeVehicleByPlaque(plaque);

        return ResponseEntity.ok(true);
    }

    /**
     * update a vehicle
     * @param vehicle
     * @return
     */
    @PutMapping("/update/vehicle")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {

        if ( vehicle == null ) {
            throw new RuntimeException("vehicle is null");
        }

        vehicleService.updateVehicle(vehicle);

        return ResponseEntity.ok(vehicle);
    }

    /**
     * get a vehicle by plaque
     * @param plaque
     * @return
     */
    @GetMapping("/get/vehicle/{plaque}")
    public ResponseEntity<Vehicle> getVehicleByPlaque(@PathVariable String plaque) {

        Vehicle vehicle = vehicleService.getVehicleByPlaque(plaque);

        if ( vehicle == null ) {
            throw new RuntimeException("vehicle don't exist");
        }

        return ResponseEntity.ok(vehicle);
    }

    /**
     * get all vehicles
     * @return
     */
    @GetMapping("/get/all/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

}
