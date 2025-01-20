package veterinaria.XYZ.dao;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import veterinaria.XYZ.dto.Paciente;
import veterinaria.XYZ.exception.DaoException;
import veterinaria.XYZ.mapper.PacienteMapper;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class PacienteImplement implements PacienteDao {

    private final JdbcTemplate jdbcTemplate;

    public PacienteImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Paciente paciente) throws DaoException {
        String INSERT = "INSERT INTO pacientes(" +
                "ds_nombre, " +
                "ds_especie, " +
                "ds_raza, " +
                "fe_nacimiento, " +
                "fe_registro, " +
                "id_tutor, " +
                "id_usuario) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        // Obtén la fecha actual para fe_registro
        Date fechaRegistro = new Date();

        try {
            jdbcTemplate.update(INSERT,
                    paciente.getNombre(),
                    paciente.getEspecie(),
                    paciente.getRaza(),
                    new java.sql.Date(paciente.getFe_nacimiento().getTime()), // Convierte a java.sql.Date
                    new java.sql.Date(fechaRegistro.getTime()),              // Convierte a java.sql.Date
                    paciente.getId_tutor().getId(),
                    paciente.getId_usuario().getId());
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
    }

    public void update(Paciente paciente ) throws DaoException{
        String update ="UPDATE pacientes SET  ds_nombre=?, ds_especie=?, ds_raza=?, fe_nacimiento=?, fe_registro=?, id_tutor=?, id_usuario=? WHERE id=?";
        try{
            UUID uuid = UUID.fromString(paciente.getId());
            UUID tutor = UUID.fromString(paciente.getId_tutor().getId());
            UUID user = UUID.fromString(paciente.getId_usuario().getId());
            jdbcTemplate.update(update, paciente.getNombre(), paciente.getEspecie(), paciente.getRaza(),paciente.getFe_nacimiento(), paciente.getFe_registro(), tutor, user, uuid );
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public void delete(Paciente paciente) throws DaoException{

        String DELETE = "DELETE FROM pacientes WHERE id=? ";
        try{
            UUID uuid = UUID.fromString(paciente.getId());
            jdbcTemplate.update(DELETE,uuid);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }


    public Paciente selectById( Paciente paciente ){
        try {
            String QUERY = "SELECT \n" +
                    "    A.ds_nombre, \n" +
                    "    A.ds_especie, \n" +
                    "    A.ds_raza, \n" +
                    "    A.fe_nacimiento, \n" +
                    "    A.fe_registro, \n" +
                    "    B.ds_nombre AS tutor,\n" +
                    "    D.ds_nombres AS usuario_atendio\n" +
                    "FROM \n" +
                    "    pacientes A\n" +
                    "INNER JOIN \n" +
                    "    tutor B ON A.id_tutor = B.id\n" +
                    "INNER JOIN \n" +
                    "    usuarios D ON A.id_usuario = D.id\n" +
                    "WHERE \n" +
                    "    A.id = ?;";
            UUID uuid = UUID.fromString(paciente.getId());
            return jdbcTemplate.queryForObject(QUERY, new PacienteMapper(),uuid);

        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    public List<Map<String, Object>> selectAll() throws DaoException{
        String selectAll = " SELECT id, ds_nombre, ds_especie, ds_raza, fe_nacimiento, fe_registro, id_tutor, id_usuario FROM pacientes";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

}
