package cl.duoc.VanessaRoberson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.VanessaRoberson.model.Mediturn;
import cl.duoc.VanessaRoberson.repository.MediturnRepository;

@Service
public class MediturnService {

    @Autowired
    private MediturnRepository mediturnRepository;

    public MediturnService (MediturnRepository mediturnRepository){
        this.mediturnRepository = mediturnRepository;
    }

    public List<Mediturn> getAllPatients(){
        return mediturnRepository.findAll();
    }

    public Optional<Mediturn> getPatientsById(Long rutPaciente){
        return mediturnRepository.findByRut(rutPaciente);
    }

    public Mediturn createPatient(Mediturn mediturn){
        return mediturnRepository.save(mediturn);
    }

    public Optional<Mediturn> updatePatient(Long rutPaciente, Mediturn mediturn){
        if(mediturnRepository.existsByRut(rutPaciente)){
            mediturn.setRutPaciente(rutPaciente);
            return Optional.of(mediturnRepository.save(mediturn));
        }
        return Optional.empty();
    }

    public boolean deletePatient(Long rutPaciente){
        if (mediturnRepository.existsByRut(rutPaciente)){
            mediturnRepository.deleteByRut(rutPaciente);
            return true;
        }
        return false;
    }
}



