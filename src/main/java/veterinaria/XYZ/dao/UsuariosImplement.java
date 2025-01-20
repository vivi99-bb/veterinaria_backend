package veterinaria.XYZ.dao;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.exception.DaoException;
import veterinaria.XYZ.mapper.UsuariosMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class UsuariosImplement implements UsuariosDao {

    private final JdbcTemplate jdbcTemplate;

    public  UsuariosImplement (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Usuarios usuarios) throws DaoException{
        String INSERT = "INSERT INTO public.usuarios(ds_correo, ds_contrasena, ds_nombres, nu_cedula)\n" +
                "\tVALUES ( ?, ?, ?, ?);";
        try{
            jdbcTemplate.update(INSERT, usuarios.getCorreo(), usuarios.getContrasena(), usuarios.getNombre(), usuarios.getCedula());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public void update(Usuarios usuarios) throws DaoException{
        String update = "UPDATE usuarios SET ds_correo=?, ds_contrasena=?, ds_nombres=?, nu_cedula=? WHERE id=?";
        try{
            UUID uuid = UUID.fromString(usuarios.getId());
            jdbcTemplate.update(update, usuarios.getCorreo(), usuarios.getContrasena(), usuarios.getNombre(),usuarios.getCedula(),uuid);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public void delete(Usuarios usuarios){
        String DELETE ="DELETE FROM usuarios WHERE id=?";
        try{
            UUID uuid = UUID.fromString(usuarios.getId());
            jdbcTemplate.update(DELETE, uuid);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public Usuarios selectById( Usuarios usuarios){
        try{
            String QUERY = "SELECT  ds_correo, ds_contrasena, ds_nombres, nu_cedula FROM usuarios WHERE id=?";
            UUID uuid = UUID.fromString(usuarios.getId());
            return jdbcTemplate.queryForObject(QUERY, new UsuariosMapper(), uuid);
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    public List<Map<String, Object>> selectAll() throws DaoException {
        String selectAll = "SELECT id, ds_correo, ds_contrasena, ds_nombres, nu_cedula FROM usuarios";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

}