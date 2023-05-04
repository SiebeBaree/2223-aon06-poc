package be.pxl.proofofconcept.controllers;

import be.pxl.proofofconcept.api.DefenseDTO;
import be.pxl.proofofconcept.api.DefenseRequest;
import be.pxl.proofofconcept.service.DefenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/defense")
public class DefenseController {

    private final DefenseService defenseService;
    public DefenseController(DefenseService defenseService) {
        this.defenseService = defenseService;
    }

    @PostMapping
    public ResponseEntity<String> createDefense(@RequestBody DefenseRequest defenseRequest) {
        return new ResponseEntity<>(defenseService.createDefense(defenseRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{defenseId}")
    public DefenseDTO updateDefense(@PathVariable String defenseId, @RequestBody DefenseRequest defenseRequest) {
        return defenseService.updateDefense(defenseId, defenseRequest);
    }

    @DeleteMapping("/{defenseId}")
    public ResponseEntity<Void> deleteDefense(@PathVariable String defenseId) {
        boolean deleted = defenseService.deleteDefense(defenseId);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
