package dto;

public class Usuarios {

    private String id,correo, contrasena, nombre;
    private int cedula;

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

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
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

    public int getCedula() {
        return cedula;
    }
}
