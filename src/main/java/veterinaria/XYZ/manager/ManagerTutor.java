package veterinaria.XYZ.manager;

import veterinaria.XYZ.dto.Tutor;
import veterinaria.XYZ.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerTutor {

    public void crear(Tutor tutor) throws ManageException;
    public Tutor selectByid(Tutor tutor) throws  ManageException;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public void delete( Tutor tutor) throws  ManageException;

}
