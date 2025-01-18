package veterinaria.XYZ.dao;

import veterinaria.XYZ.dto.Paciente;
import veterinaria.XYZ.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface PacienteDao {

    public void insert(Paciente paciente) throws DaoException;
    public void update(Paciente paciente) throws DaoException;
    public void delete(Paciente paciente) throws DaoException;
    public Paciente selectById(Paciente paciente);
    public List<Map<String, Object>> selectAll() throws  DaoException;

}
