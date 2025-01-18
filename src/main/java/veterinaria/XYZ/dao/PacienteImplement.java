package veterinaria.XYZ.dao;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import veterinaria.XYZ.dto.Paciente;
import veterinaria.XYZ.exception.DaoException;
import veterinaria.XYZ.mapper.PacienteMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class PacienteImplement implements PacienteDao {

    private final JdbcTemplate jdbcTemplate;

    public PacienteImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Paciente paciente)throws DaoException {
        String INSERT ="INSERT INTO pacientes(" +
                "id, " +
                "ds_nombre, " +
                "ds_especie, " +
                "ds_raza, " +
                "fe_nacimiento, " +
                "fe_registro, " +
                "id_tutor, " +
                "id_usuario)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";


        try{
            String uuid = UUID.randomUUID().toString();
            paciente.setId(uuid);

            jdbcTemplate.update(INSERT,
                    paciente.getId(),
                    paciente.getNombre(),
                    paciente.getEspecie(),
                    paciente.getRaza(),
                    paciente.getFe_nacimiento(),
                    paciente.getFe_registro(),
                    paciente.getId_tutor().getId(),
                    paciente.getId_usuario().getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public void update(Paciente paciente ) throws DaoException{
        String update ="UPDATE pacientes SET  ds_nombre=?, ds_especie=?, ds_raza=?, fe_nacimiento=?, fe_registro=?, id_tutor=?, id_usuario=? WHERE id=?";
        try{
            jdbcTemplate.update(update, paciente.getNombre(), paciente.getEspecie(), paciente.getRaza(),paciente.getFe_nacimiento(), paciente.getFe_registro(), paciente.getId_tutor().getId(), paciente.getId_usuario().getId(), paciente.getId() );
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public void delete(Paciente paciente) throws DaoException{

        String DELETE = "DELETE FROM pacientes WHERE id=? ";
        try{
            jdbcTemplate.update(DELETE,paciente.getId());
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
            return jdbcTemplate.queryForObject(QUERY, new PacienteMapper(),paciente.getId());

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
