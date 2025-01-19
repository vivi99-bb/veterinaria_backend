package veterinaria.XYZ.business;

import org.apache.logging.log4j.MarkerManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import veterinaria.XYZ.dto.Paciente;
import veterinaria.XYZ.dto.Usuarios;
import veterinaria.XYZ.exception.BusinessException;
import veterinaria.XYZ.exception.ManageException;
import veterinaria.XYZ.manager.ManagerPaciente;

import java.util.List;
import java.util.Map;

@Component
public class BusinessPacienteImplement  implements  BusinessPaciente{

    private ManagerPaciente managerPaciente;

    public BusinessPacienteImplement(ManagerPaciente managerPaciente) {
        this.managerPaciente = managerPaciente;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar(Paciente paciente) throws BusinessException {
        try{
            managerPaciente.crear(paciente);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Paciente selectById(Paciente paciente) throws BusinessException{
       Paciente pacienteData=null;
        try{
            pacienteData = managerPaciente.selectById(paciente);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
        return pacienteData;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{
        try{

            return  this.managerPaciente.selectAll();
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete( Paciente paciente) throws BusinessException{
        try{
            this.managerPaciente.delete(paciente);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
    }

}
