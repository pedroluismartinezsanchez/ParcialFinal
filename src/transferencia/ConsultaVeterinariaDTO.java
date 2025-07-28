/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferencia;

/**
 *
 * @author PEDRO LUIS MARTINEZ
 */
import java.time.LocalDate;

public class ConsultaVeterinariaDTO {

    private String idConsulta;
    private String idMascota;
    private String idVeterinario;
    private LocalDate fecha;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private boolean vacunaAplicada;

    public ConsultaVeterinariaDTO(String idConsulta, String idMascota, String idVeterinario, LocalDate fecha,
            String motivo, String diagnostico, String tratamiento, boolean vacunaAplicada) {
        this.idConsulta = idConsulta;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.vacunaAplicada = vacunaAplicada;
    }

    // Getters y Setters
    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public boolean isVacunaAplicada() {
        return vacunaAplicada;
    }

}
