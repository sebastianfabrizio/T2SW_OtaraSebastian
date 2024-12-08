package pe.com.cibertec.t2sw_otarasebastian.exception;

public class ResourceNotFoundException extends RuntimeException {

    //contructor
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}