package com.itsx.slasher.italikaapirest.repository;

import com.itsx.slasher.italikaapirest.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {
}
