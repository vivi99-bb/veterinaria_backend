package veterinaria.XYZ.dao;

import veterinaria.XYZ.dto.Tutor;
import veterinaria.XYZ.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface TutorDao {

    public void insert(Tutor tutor) throws DaoException;
    public void update(Tutor tutor) throws DaoException;
    public void delete(Tutor tutor) throws DaoException;
    public Tutor selectById(Tutor tutor);
    public List<Map<String, Object>> selectAll() throws  DaoException;

}
