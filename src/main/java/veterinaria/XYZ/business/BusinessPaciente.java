package veterinaria.XYZ.business;

import veterinaria.XYZ.dto.Paciente;
import veterinaria.XYZ.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface BusinessPaciente {
    public void registrar(Paciente paciente) throws BusinessException;
    public Paciente selectById(Paciente paciente) throws BusinessException;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete(Paciente paciente) throws BusinessException;

}
