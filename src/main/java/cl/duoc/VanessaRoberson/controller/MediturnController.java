package cl.duoc.VanessaRoberson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.VanessaRoberson.model.Mediturn;
import cl.duoc.VanessaRoberson.service.MediturnService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping
public class MediturnController {
    @Autowired
    private MediturnService mediturnService;

    @GetMapping
    public ResponseEntity<List<Mediturn>> getAllPatients(){
        return ResponseEntity.ok(mediturnService.getAllPatients());
    }
    

}
