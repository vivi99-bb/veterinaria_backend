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
        String INSERT = "INSERT INTO public.Tutor (id, ds_nombre, ds_tipo_identif, nu_identificacion, ds_ciudad, ds_direccion, nu_telefono)VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            String uuid = UUID.randomUUID().toString();
            tutor.setId(uuid);

            jdbcTemplate.update(INSERT, tutor.getId(), tutor.getNombre(), tutor.getTipoIdentidad(), tutor.getNroIdentificacion(), tutor.getCiudad(), tutor.getDireccion(), tutor.getTelefono());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }


    public void update(Tutor tutor) throws DaoException {
        String update ="UPDATE Tutor SET  ds_nombre=?, ds_tipo_identif=?, nu_identificacion=?, ds_ciudad=?, ds_direccion=?, nu_telefono=? WHERE id=?";
        try{
            jdbcTemplate.update(update, tutor.getNombre(), tutor.getTipoIdentidad(), tutor.getNroIdentificacion(), tutor.getCiudad(), tutor.getDireccion(), tutor.getTelefono(), tutor.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public void delete(Tutor tutor) throws DaoException {
        String DELETE ="DELETE FROM Tutor WHERE id=?";
        try{
            jdbcTemplate.update(DELETE,tutor.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public Tutor selectById( Tutor tutor){
        try{
            String QUERY = "SELECT  ds_nombre, ds_tipo_identif, nu_identificacion, ds_ciudad, ds_direccion, nu_telefono FROM Tutor WHERE id=?";

            return jdbcTemplate.queryForObject(QUERY, new TutorMapper(), tutor.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    public List<Map<String, Object>> selectAll() throws DaoException {
        String selectAll = "SELECT id, ds_nombre, ds_tipo_identif, nu_identificacion, ds_ciudad, ds_direccion, nu_telefono FROM Tutor";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

}
