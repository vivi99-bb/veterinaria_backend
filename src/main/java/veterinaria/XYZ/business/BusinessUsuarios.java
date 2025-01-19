package veterinaria.XYZ.business;

import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface BusinessUsuarios {
    public void registrar(Usuarios usuarios) throws BusinessException;
    public Usuarios selectById(Usuarios usuarios) throws BusinessException;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete( Usuarios usuarios  ) throws BusinessException;

}
