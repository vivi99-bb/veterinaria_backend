package veterinaria.XYZ.business;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import veterinaria.XYZ.dto.Tutor;
import veterinaria.XYZ.exception.BusinessException;
import veterinaria.XYZ.exception.ManageException;
import veterinaria.XYZ.manager.ManagerTutor;

import java.util.List;
import java.util.Map;

@Component
public class BusinessTutorImplement implements BusinessTutor {

    private ManagerTutor managerTutor;

    public BusinessTutorImplement(ManagerTutor managerTutor) {
        this.managerTutor = managerTutor;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar(Tutor tutor) throws BusinessException {
        try{
            managerTutor.crear(tutor);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Tutor selectById(Tutor tutor) throws BusinessException{
       Tutor tutorData=null;
        try{
            tutorData = managerTutor.selectById(tutor);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
        return tutorData;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{
        try{

            return  this.managerTutor.selectAll();
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete( Tutor tutor ) throws BusinessException{
        try{
            this.managerTutor.delete(tutor);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
    }



}
