package pe.com.cibertec.t2sw_otarasebastian.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService {

    private final Path folderImagen = Paths.get("imagen");
    private final Path folderImagenes = Paths.get("imagenes");
    private static final List<String> ALLOWED_EXTENSIONS = List.of("pdf", "png", "docx");
    private static final long MAX_FILE_SIZE = 25 * 1024 * 1024;

    @Override
    public void guardarArchivo(MultipartFile file) throws Exception {
        validarArchivo(file);
        Files.copy(file.getInputStream(), folderImagen.resolve(file.getOriginalFilename()));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> files) throws Exception {
        if (files.size() != 3) {
            throw new IllegalArgumentException("Debes subir exactamente 3 archivos.");
        }
        for (MultipartFile file : files) {
            validarArchivo(file);
            Files.copy(file.getInputStream(), folderImagenes.resolve(file.getOriginalFilename()));
        }
    }

    private void validarArchivo(MultipartFile file) {
        validarTamaño(file);
        validarExtension(file);
    }

    private void validarTamaño(MultipartFile file) {
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("El tamaño máximo del archivo es 25 MB.");
        }
    }

    private void validarExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.lastIndexOf('.') == -1) {
            throw new IllegalArgumentException("El archivo no tiene una extensión válida.");
        }
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        if (!ALLOWED_EXTENSIONS.contains(extension)) {
            throw new IllegalArgumentException("Extensión no permitida. Permitidas: " + ALLOWED_EXTENSIONS);
        }
    }
}
