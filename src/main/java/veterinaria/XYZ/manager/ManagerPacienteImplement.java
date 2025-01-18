package veterinaria.XYZ.manager;

import org.springframework.stereotype.Component;
import veterinaria.XYZ.dao.PacienteDao;
import veterinaria.XYZ.dto.Paciente;
import veterinaria.XYZ.exception.DaoException;
import veterinaria.XYZ.exception.ManageException;

import java.util.List;
import java.util.Map;

@Component
public class ManagerPacienteImplement  implements  ManagerPaciente{

    private PacienteDao pacienteDao;

    public ManagerPacienteImplement(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public void crear(Paciente paciente) throws ManageException {
        Paciente pacienteDato = null;

        try {
            pacienteDato = pacienteDao.selectById(paciente);
            if(pacienteDato==null){
                pacienteDao.insert(paciente);
            }else{
                pacienteDao.update(paciente);

            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch(Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }


    public Paciente selectByid(Paciente paciente) throws ManageException {
        Paciente pacienteDato = null;
        try{
            pacienteDato =pacienteDao.selectById(paciente);

        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
        return pacienteDato;
    }


    public List<Map<String, Object>> selectAll() throws ManageException {
        try{
            return this.pacienteDao.selectAll();
        } catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        } catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }

    public void delete(Paciente paciente) throws ManageException {
        try{
            if(paciente.getId()!=null) {
                pacienteDao.delete(paciente);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }
}
