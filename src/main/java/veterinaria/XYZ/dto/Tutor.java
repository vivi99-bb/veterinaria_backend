package veterinaria.XYZ.dto;

public class Tutor {

    private String id, nombre, tipoIdentidad, ciudad, direccion;
    private long  telefono;
    private long nroIdentificacion;

    public Tutor() {
        this.id = "";
        this.nombre = "";
        this.tipoIdentidad = "";
        this.ciudad = "";
        this.direccion = "";
        this.nroIdentificacion = 0;
        this.telefono = 0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoIdentidad(String tipoIdentidad) {
        this.tipoIdentidad = tipoIdentidad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNroIdentificacion(long nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }




    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoIdentidad() {
        return tipoIdentidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public long getNroIdentificacion() {
        return nroIdentificacion;
    }

    public long getTelefono() {
        return telefono;
    }
}
