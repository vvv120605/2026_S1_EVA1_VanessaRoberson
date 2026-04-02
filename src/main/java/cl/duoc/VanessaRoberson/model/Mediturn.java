package cl.duoc.VanessaRoberson.model;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mediturn {

    @NotNull (message = "Debe ingresar el rut del paciente sin dígito verificador")
    private Long rutPaciente;

    @NotBlank (message = "El dígito verificador no puede estar en blanco")
    private String digitoVerificador;

    @NotBlank (message = "El nombre del paciente no puede estar en blanco")
    private String nombrePaciente;

    @NotBlank (message = "Los apellidos del paciente no pueden estar en blanco")
    private String apellidosPaciente;

    private Date fNacimientoPac;

    @NotBlank (message = "El tipo de atención/especialidad requerida no puede estar en blanco")
    private String tipoEspecialidad;

    @NotBlank (message = "El estado de solicitud no puede estar en blanco. Ingrese RESUELTO/PENDIENTE/DENEGADO")
    private String estadoSolicitud;

    @NotNull (message = "Debe ingresar una fecha de registro")
    private Date fechaRegistro;

    @NotBlank (message = "El nivel de prioridad de la atención requerida no puede estar en blanco")
    private String nivelPrioridad;

}
