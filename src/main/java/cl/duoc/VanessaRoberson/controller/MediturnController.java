package cl.duoc.VanessaRoberson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.VanessaRoberson.model.Mediturn;
import cl.duoc.VanessaRoberson.service.MediturnService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/Mediturn")
public class MediturnController {

    @Autowired
    private MediturnService mediturnService;

    @GetMapping
    public ResponseEntity<List<Mediturn>> getAllPatients(){
        return ResponseEntity.ok(mediturnService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientsById(@PathVariable Long rutPaciente){
        return mediturnService.getPatientsById(rutPaciente)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@Valid @RequestBody Mediturn mediturn) {
        return ResponseEntity.ok(mediturnService.createPatient(mediturn));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long rutPaciente, @Valid @RequestBody Mediturn mediturn) {
        return mediturnService.updatePatient(rutPaciente, mediturn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient (@PathVariable Long rutPaciente){
        return mediturnService.deletePatient(rutPaciente)
            ? ResponseEntity.noContent().build()
            : ResponseEntity.notFound().build();
    }

}
