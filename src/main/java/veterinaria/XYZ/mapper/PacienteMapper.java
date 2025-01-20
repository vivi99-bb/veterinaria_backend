package veterinaria.XYZ.mapper;

import veterinaria.XYZ.dto.Paciente;
import veterinaria.XYZ.dto.Tutor;
import veterinaria.XYZ.dto.Usuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteMapper implements RowMapper<Paciente> {

    public Paciente  mapRow(ResultSet resultSet, int i) throws SQLException {

        Paciente paciente = new Paciente();
        Tutor tutor = new Tutor();
        Usuarios usuarios = new Usuarios();

        paciente.setNombre(resultSet.getString("ds_nombre"));
        paciente.setEspecie(resultSet.getString("ds_especie"));
        paciente.setRaza(resultSet.getString("ds_raza"));
        paciente.setFe_nacimiento(resultSet.getDate("fe_nacimiento"));
        paciente.setFe_registro(resultSet.getDate("fe_registro"));

        tutor.setId(resultSet.getString("id_tutor"));
        paciente.setId_tutor(tutor);

        usuarios.setId(resultSet.getString("id_usuario"));
        paciente.setId_usuario(usuarios);

        return paciente;


    }



}
