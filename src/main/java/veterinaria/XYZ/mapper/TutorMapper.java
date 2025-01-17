package veterinaria.XYZ.mapper;


import veterinaria.XYZ.dto.Tutor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorMapper implements RowMapper<Tutor> {

    @Override
    public Tutor mapRow(ResultSet resultSet, int i) throws SQLException {
        Tutor tutor = new Tutor();
        tutor.setNombre(resultSet.getString("ds_nombre"));
        tutor.setTipoIdentidad(resultSet.getString("ds_tipo_identif"));
        tutor.setNroIdentificacion(resultSet.getInt("nu_identificacion"));
        tutor.setCiudad(resultSet.getString("ds_ciudad"));
        tutor.setDireccion(resultSet.getString("ds_direccion"));
        tutor.setTelefono(resultSet.getInt("nu_telefono"));

        return tutor;
    }
}
