package cl.duoc.VanessaRoberson.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.duoc.VanessaRoberson.model.Mediturn;

@Repository
public class MediturnRepository {
    private final Map <Long, Mediturn> mediturnEmpresa = new HashMap<>();

    //Método para obtener todos los objetos
    public List<Mediturn> findAll(){
        return new ArrayList<>(mediturnEmpresa.values());
    }

    //Método para encontrar por rut
    public Optional<Mediturn> findByRut(Long rutPaciente){
        return Optional.ofNullable(mediturnEmpresa.get(rutPaciente));
    }

    //Método para guardar o actualizar datos de paciente
    public Mediturn save(Mediturn datosPaciente){
        mediturnEmpresa.put(datosPaciente.getRutPaciente(), datosPaciente);
        return datosPaciente;
    }

    //Método para eliminar paciente y datos de cita
    public void deleteByRut(Long rutPaciente){
        mediturnEmpresa.remove(rutPaciente);
    }
        
    //Método para revisar existencia de paciente ingresando RUT
    public boolean existsByRut(Long rutPaciente){
        return mediturnEmpresa.containsKey(rutPaciente);
    }
}
