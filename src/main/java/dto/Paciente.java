package dto;

import java.util.Date;

public class Paciente {

    private String id, nombre, especie, raza, id_tutor, id_usuario;
    private Date fe_nacimiento, fe_registro;

    public Paciente() {
        this.id = "";
        this.nombre = "";
        this.especie = "";
        this.raza = "";
        this.id_tutor = "";
        this.id_usuario = "";
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

    public void setId_tutor(String id_tutor) {
        this.id_tutor = id_tutor;
    }

    public void setId_usuario(String id_usuario) {
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

    public String getId_tutor() {
        return id_tutor;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public Date getFe_nacimiento() {
        return fe_nacimiento;
    }

    public Date getFe_registro() {
        return fe_registro;
    }
}
