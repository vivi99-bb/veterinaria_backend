package veterinaria.XYZ.dto;

public class Tutor {

    private String id, nombre, tipoIdentidad, ciudad, direccion;
    private int nroIdentificacion, telefono;

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

    public void setNroIdentificacion(int nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public void setTelefono(int telefono) {
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

    public int getNroIdentificacion() {
        return nroIdentificacion;
    }

    public int getTelefono() {
        return telefono;
    }
}
