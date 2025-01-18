package veterinaria.XYZ.dao;

import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface UsusariosDao {

    public void insert(Usuarios usuarios) throws DaoException;
    public void update(Usuarios usuarios) throws DaoException;
    public void delete(Usuarios usuarios) throws DaoException;
    public Usuarios selectById(Usuarios usuarios);
    public List<Map<String, Object>> selectAll() throws  DaoException;

}
