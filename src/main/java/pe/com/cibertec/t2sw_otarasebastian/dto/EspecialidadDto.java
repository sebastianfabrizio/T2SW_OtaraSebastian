package pe.com.cibertec.t2sw_otarasebastian.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class EspecialidadDto {
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private LocalDateTime fechgraduacion;

}
