package com.itsx.slasher.italikaapirest.apirest;

import com.itsx.slasher.italikaapirest.entity.Administrator;
import com.itsx.slasher.italikaapirest.service.AdministratorService;
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
@RequestMapping("/api/administrator")
public class AdministratorRestController {

    private AdministratorService administratorService;

    @Autowired
    public AdministratorRestController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    /**
     * The creation of an administrator
     * @param administrator
     * @return
     */
    @PostMapping("/create/administrator")
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator) {
        administratorService.createAdministrator(administrator);
        return ResponseEntity.ok(administrator);
    }

    /**
     * End point to remove an administrator to data base
     * @param folio
     * @return
     */
    @DeleteMapping("/delete/administrator/{folio}")
    public ResponseEntity<Boolean> deleteAdministratorByFolio(@PathVariable Long folio) {

        Administrator administrator = administratorService.getAdministratorByFolio(folio);

        if ( administrator == null ) {
            throw new RuntimeException("Administrator doesn't exist - " + folio);
        }

        administratorService.removeAdministratorByFolio(folio);

        return ResponseEntity.ok(true);
    }

    /**
     * To update administrator
     * @param administrator
     * @return
     */
    @PutMapping("/update/administrator")
    public ResponseEntity<Administrator> updateAdministrator(@RequestBody Administrator administrator) {
        administratorService.updateAdministrator(administrator);
        return ResponseEntity.ok(administrator);
    }

    /**
     * To get an administrator
     * @param folio
     * @return
     */
    @GetMapping("/get/administrator/{folio}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long folio) {
        Administrator administrator = administratorService.getAdministratorByFolio(folio);

        if ( administrator == null ) {
            throw new RuntimeException("Administrator doesn't exist - " + folio);
        }

        return ResponseEntity.ok(administrator);
    }

    /**
     * To get all administrators
     * @return
     */
    @GetMapping("/get/all/administrators")
    public ResponseEntity<List<Administrator>> getAlAdministrators() {
        return ResponseEntity.ok(administratorService.getAllAdministrators());
    }
}
