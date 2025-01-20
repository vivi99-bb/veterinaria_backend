package veterinaria.XYZ.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import veterinaria.XYZ.dto.Tutor;
import veterinaria.XYZ.exception.DaoException;
import veterinaria.XYZ.mapper.TutorMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class TutorImplement  implements  TutorDao{

    private final JdbcTemplate jdbcTemplate;

    public TutorImplement (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Tutor tutor) throws DaoException {
        String INSERT = "INSERT INTO public.tutor ( ds_nombre, ds_tipo_identif, nu_identificacion, ds_ciudad, ds_direccion, nu_telefono)VALUES ( ?, ?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(INSERT,  tutor.getNombre(), tutor.getTipoIdentidad(), tutor.getNroIdentificacion(), tutor.getCiudad(), tutor.getDireccion(), tutor.getTelefono());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }


    public void update(Tutor tutor) throws DaoException {
        String update ="UPDATE tutor SET  ds_nombre=?, ds_tipo_identif=?, nu_identificacion=?, ds_ciudad=?, ds_direccion=?, nu_telefono=? WHERE id=?";
        try{
            UUID uuid = UUID.fromString(tutor.getId());
            jdbcTemplate.update(update, tutor.getNombre(), tutor.getTipoIdentidad(), tutor.getNroIdentificacion(), tutor.getCiudad(), tutor.getDireccion(), tutor.getTelefono(), uuid);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public void delete(Tutor tutor) throws DaoException {
        String DELETE ="DELETE FROM tutor WHERE id=?";
        try{
            UUID uuid = UUID.fromString(tutor.getId());
            jdbcTemplate.update(DELETE,uuid);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public Tutor selectById( Tutor tutor){
        try{
            String QUERY = "SELECT  ds_nombre, ds_tipo_identif, nu_identificacion, ds_ciudad, ds_direccion, nu_telefono FROM tutor WHERE id=?";
            UUID uuid = UUID.fromString(tutor.getId());
            return jdbcTemplate.queryForObject(QUERY, new TutorMapper(), uuid);
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    public List<Map<String, Object>> selectAll() throws DaoException {
        String selectAll = "SELECT id, ds_nombre, ds_tipo_identif, nu_identificacion, ds_ciudad, ds_direccion, nu_telefono FROM tutor";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

}
