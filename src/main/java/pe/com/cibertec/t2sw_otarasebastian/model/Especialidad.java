package pe.com.cibertec.t2sw_otarasebastian.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "Especialidad")
@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private LocalDateTime fechgraduacion;

    @ManyToOne
    @JoinColumn(name = "idmedico", nullable = false)
    private Medico medico;


}
