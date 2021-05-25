package com.itsx.slasher.italikaapirest.apirest;

import com.itsx.slasher.italikaapirest.entity.Mechanic;
import com.itsx.slasher.italikaapirest.service.MechanicService;
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
@RequestMapping("/api/mechanic")
public class MechanicRestController {

    private MechanicService mechanicService;

    @Autowired
    public MechanicRestController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    /**
     * create a mechanic
     * @param mechanic
     * @return
     */
    @PostMapping("/create/mechanic")
    public ResponseEntity<Mechanic> createMechanic(@RequestBody Mechanic mechanic) {
        if ( mechanic == null ) {
            throw new RuntimeException("this mechanic is null");
        }

        mechanicService.createMechanic(mechanic);

        return ResponseEntity.ok(mechanic);
    }

    /**
     * delete a mechanic by folio
     * @param folio
     * @return
     */
    @DeleteMapping("/delete/mechanic/{folio}")
    public ResponseEntity<Boolean> deleteMechanicByFolio(@PathVariable Long folio) {

        Mechanic mechanic = mechanicService.getMechanicByFolio(folio);

        if ( mechanic == null ) {
            throw new RuntimeException("mechanic doesn't exist - " + folio);
        }

        mechanicService.removeMechanicByFolio(folio);

        return ResponseEntity.ok(true);
    }

    /**
     * update a mechanic
     * @param mechanic
     * @return
     */
    @PutMapping("/update/mechanic")
    public ResponseEntity<Mechanic> updateMechanic(@RequestBody Mechanic mechanic) {

        if ( mechanic == null ) {
            throw new RuntimeException("mechanic is null");
        }

        mechanicService.updateMechanic(mechanic);

        return ResponseEntity.ok(mechanic);
    }

    /**
     * Get a mechanic by folio
     * @param folio
     * @return
     */
    @GetMapping("/get/mechanic/{folio}")
    public ResponseEntity<Mechanic> getMechanicByFolio(@PathVariable Long folio) {
        Mechanic mechanic = mechanicService.getMechanicByFolio(folio);

        if ( mechanic == null ) {
            throw new RuntimeException("mechanic doesn't exist - " + folio);
        }

        return ResponseEntity.ok(mechanic);
    }

    /**
     * Get all mechanics
     * @return
     */
    @GetMapping("/get/all/mechanics")
    public ResponseEntity<List<Mechanic>> getAllMechanics() {
        List<Mechanic> mechanics = mechanicService.getAllMechanics();
        return ResponseEntity.ok(mechanics);
    }

}
