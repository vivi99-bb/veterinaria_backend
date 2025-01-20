package veterinaria.XYZ.dto;

public class Usuarios {

    private String id,correo, contrasena, nombre;
    private long cedula;

    public Usuarios() {
        this.contrasena = "";
        this.id = "";
        this.correo = "";
        this.nombre = "";
        this.cedula = 0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }


    public String getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public long getCedula() {
        return cedula;
    }
}
