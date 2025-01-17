package veterinaria.XYZ.dto;

import java.util.Date;

public class Paciente {

    private String id, nombre, especie, raza;
    private Date fe_nacimiento, fe_registro;
    private Tutor id_tutor;
    private Usuarios id_usuario;

    public Paciente() {
        this.id = "";
        this.nombre = "";
        this.especie = "";
        this.raza = "";
        this.id_tutor = new Tutor();
        this.id_usuario = new Usuarios();
        this.fe_nacimiento = new Date();
        this.fe_registro = new Date();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setId_tutor(Tutor id_tutor) {
        this.id_tutor = id_tutor;
    }

    public void setId_usuario(Usuarios id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setFe_nacimiento(Date fe_nacimiento) {
        this.fe_nacimiento = fe_nacimiento;
    }

    public void setFe_registro(Date fe_registro) {
        this.fe_registro = fe_registro;
    }




    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public Tutor getId_tutor() {
        return id_tutor;
    }

    public Usuarios getId_usuario() {
        return id_usuario;
    }

    public Date getFe_nacimiento() {
        return fe_nacimiento;
    }

    public Date getFe_registro() {
        return fe_registro;
    }
}
