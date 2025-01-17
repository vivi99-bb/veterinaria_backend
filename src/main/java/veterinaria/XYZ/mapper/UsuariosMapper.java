package veterinaria.XYZ.mapper;

import veterinaria.XYZ.dto.Usuarios;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosMapper implements RowMapper<Usuarios> {

    @Override
    public Usuarios mapRow(ResultSet resultSet, int i) throws SQLException{
        Usuarios usuarios = new Usuarios();
        usuarios.setCorreo(resultSet.getString("ds_correo"));
        usuarios.setContraseña(resultSet.getString("ds_contraseña"));
        usuarios.setNombre(resultSet.getString("ds_nombres"));
        usuarios.setCedula(resultSet.getInt("nu_cedula"));

        return usuarios;

    }
}
