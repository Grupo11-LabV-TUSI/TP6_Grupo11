package utnfrgp.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

@NamedQueries({
    @NamedQuery(
        name = "findMedicoByMatricula",
        query = "SELECT m FROM Medico m WHERE matricula=:matricula"
    ),
    @NamedQuery(
        name = "findAllMedicos",
        query = "SELECT m FROM Medico m"
    ),
    @NamedQuery(
        name = "findAllMedicosOrderByMatricula",
        query = "FROM Medico m ORDER BY m.matricula ASC"
    ),
    @NamedQuery(
        name = "findAllMedicoLegajos",
        query = "SELECT m.matricula FROM Medico m"
    )
})

@Entity
@Table(name="Medico")
public class Medico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="matricula")
    private int matricula;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="email")
    private String email;

    @Column(name="telefono")
    private String telefono;

    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn(name="especialidad_id")
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Horario> horarios;
    
    @Column(name="estado")
    private boolean estado;

    // Constructor vacío para Hibernate
    public Medico() {}

    public Medico(int matricula, String nombre, String apellido, String email, String telefono,
                  LocalDate fechaNacimiento, Usuario usuario, Especialidad especialidad, boolean estado) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    // Getters y setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Medico [matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
                + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", usuario=" + usuario
                + ", especialidad=" + especialidad + "]";
    }
}
