package com.itsx.slasher.italikaapirest.apirest;

import com.itsx.slasher.italikaapirest.entity.TypeOfWork;
import com.itsx.slasher.italikaapirest.service.TypeOfWorkService;
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
@RequestMapping("/api/typeofwork")
public class TypeOfWorkRestController {

    private TypeOfWorkService typeOfWorkService;

    @Autowired
    public TypeOfWorkRestController(TypeOfWorkService typeOfWorkService) {
        this.typeOfWorkService = typeOfWorkService;
    }

    /**
     * Create a type of work
     * @param typeOfWork
     * @return
     */
    @PostMapping("/create/typeofwork")
    public ResponseEntity<TypeOfWork> createTypeOfWork(@RequestBody TypeOfWork typeOfWork) {

        if ( typeOfWork == null ) {
            throw new RuntimeException("type of work is null");
        }

        typeOfWorkService.createTypeOfWork(typeOfWork);

        return ResponseEntity.ok(typeOfWork);
    }

    /**
     * Delete type of work by folio
     * @param folio
     * @return
     */
    @DeleteMapping("/delete/typeofwork/{folio}")
    public ResponseEntity<Boolean> deleteTypeOfWorkByFolio(@PathVariable Long folio) {

        TypeOfWork typeOfWork = typeOfWorkService.getTypeOfWorkByFolio(folio);

        if ( typeOfWork == null ) {
            throw new RuntimeException("type of work doesn't exist - " + folio);
        }

        typeOfWorkService.removeTypeOfWorkByFolio(folio);

        return ResponseEntity.ok(true);
    }

    /**
     * Update a type of work
     * @param typeOfWork
     * @return
     */
    @PutMapping("/update/typeofwork")
    public ResponseEntity<TypeOfWork> updateTypeOfWork(@RequestBody TypeOfWork typeOfWork) {

        if ( typeOfWork == null ) {
            throw new RuntimeException("type of work is null");
        }

        typeOfWorkService.updateTypeOfWork(typeOfWork);

        return ResponseEntity.ok(typeOfWork);
    }

    /**
     * Get type of work by folio
     * @param folio
     * @return
     */
    @GetMapping("/get/typeofwork/{folio}")
    public ResponseEntity<TypeOfWork> getTypeOfWorkByFolio(@PathVariable Long folio) {

        TypeOfWork typeOfWork = typeOfWorkService.getTypeOfWorkByFolio(folio);

        if ( typeOfWork == null ) {
            throw new RuntimeException("type of work doesn't exist - " + folio );
        }

        return ResponseEntity.ok(typeOfWork);
    }

    /**
     * Get all type of work
     * @return
     */
    @GetMapping("/get/all/typeofwork")
    public ResponseEntity<List<TypeOfWork>> getAllTypeOfWork() {
        List<TypeOfWork> typeOfWorks = typeOfWorkService.getAllTypeOfWorks();
        return ResponseEntity.ok(typeOfWorks);
    }

}
