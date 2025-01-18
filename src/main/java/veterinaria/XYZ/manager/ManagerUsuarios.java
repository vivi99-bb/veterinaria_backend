package veterinaria.XYZ.manager;

import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerUsuarios {

    public void crear(Usuarios usuarios) throws ManageException;
    public Usuarios selectByid(Usuarios usuarios) throws  ManageException;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public void delete( Usuarios usuarios) throws  ManageException;
}
