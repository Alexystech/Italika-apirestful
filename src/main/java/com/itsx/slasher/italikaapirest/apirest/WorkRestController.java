package com.itsx.slasher.italikaapirest.apirest;

import com.itsx.slasher.italikaapirest.entity.Work;
import com.itsx.slasher.italikaapirest.service.WorkService;
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
@RequestMapping("/api/work")
public class WorkRestController {

    private WorkService workService;

    @Autowired
    public WorkRestController(WorkService workService) {
        this.workService = workService;
    }

    /**
     * create a work
     * @param work
     * @return
     */
    @PostMapping("/create/work")
    public ResponseEntity<Work> createWork(@RequestBody Work work) {

        if ( work == null ) {
            throw new RuntimeException("the work is null");
        }

        workService.createWork(work);

        return ResponseEntity.ok(work);
    }

    /**
     * delete a work by folio
     * @param folio
     * @return
     */
    @DeleteMapping("/delete/work/{folio}")
    public ResponseEntity<Boolean> deleteWorkByFolio(@PathVariable Long folio) {

        Work work = workService.getWorkByFolio(folio);

        if ( work == null ) {
            throw new RuntimeException("work don't exist - " + folio);
        }

        workService.removeWorkByFolio(folio);

        return ResponseEntity.ok(true);
    }

    /**
     * update a work
     * @param work
     * @return
     */
    @PutMapping("/update/work")
    public ResponseEntity<Work> updateWork(@RequestBody Work work) {

        if ( work == null ) {
            throw new RuntimeException("the work is null");
        }

        workService.updateWork(work);

        return ResponseEntity.ok(work);
    }

    /**
     * get a work by folio
     * @param folio
     * @return
     */
    @GetMapping("/get/work/{folio}")
    public ResponseEntity<Work> getWorkByFolio(@PathVariable Long folio) {

        Work work = workService.getWorkByFolio(folio);

        if ( work == null ) {
            throw new RuntimeException("the work don't exist - " + folio );
        }

        return ResponseEntity.ok(work);
    }

    /**
     * get all works
     * @return
     */
    @GetMapping("/get/all/works")
    public ResponseEntity<List<Work>> getAllWorks() {
        List<Work> works = workService.getAllWorks();
        return ResponseEntity.ok(works);
    }

}
