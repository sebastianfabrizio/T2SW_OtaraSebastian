package pe.com.cibertec.t2sw_otarasebastian.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    void guardarArchivo(MultipartFile file)
            throws Exception;

    void guardarArchivos(List<MultipartFile> files)
            throws Exception;
}
