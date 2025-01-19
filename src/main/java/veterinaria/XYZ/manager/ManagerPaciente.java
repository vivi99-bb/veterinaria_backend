package veterinaria.XYZ.manager;

import veterinaria.XYZ.dto.Paciente;
import veterinaria.XYZ.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerPaciente {
    public void crear(Paciente paciente) throws ManageException;
    public Paciente selectById(Paciente paciente) throws  ManageException;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public void delete(Paciente paciente) throws  ManageException;

}
