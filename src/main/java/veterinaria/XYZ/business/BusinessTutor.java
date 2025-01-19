package veterinaria.XYZ.business;

import veterinaria.XYZ.dto.Tutor;
import veterinaria.XYZ.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface BusinessTutor {

    public void registrar(Tutor tutor) throws BusinessException;
    public Tutor selectById(Tutor tutor) throws BusinessException;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete(Tutor tutor) throws BusinessException;

}
