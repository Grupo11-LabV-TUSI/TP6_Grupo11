package utnfrgp.entidad;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.*;

@Entity
@Table(name="Horario")
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="dia")
    private String dia;
    
    @Column(name="hora_inicio")
    private LocalTime horaInicio;
    
    @Column(name="hora_fin")
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    
    public Horario() {}

    public Horario(String dia, LocalTime horaInicio, LocalTime horaFin, Medico medico) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.medico = medico;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
