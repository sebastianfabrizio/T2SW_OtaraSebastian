package pe.com.cibertec.t2sw_otarasebastian.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class MedicoDto {
    private Integer idmedico;
    private String nommedico;
    private String apemedico;
    private LocalDateTime fechnacmedico;
}
