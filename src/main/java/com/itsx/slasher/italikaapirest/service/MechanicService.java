package com.itsx.slasher.italikaapirest.service;

import com.itsx.slasher.italikaapirest.entity.Mechanic;

import java.util.List;

public interface MechanicService {
    boolean createMechanic(Mechanic mechanic);
    boolean removeMechanicByFolio(long folio);
    boolean updateMechanic(Mechanic mechanic);
    Mechanic getMechanicByFolio(long folio);
    List<Mechanic> getAllMechanics();
}
